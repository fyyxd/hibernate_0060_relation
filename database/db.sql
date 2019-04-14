表和表之间的关系有3种：
1:1
	husband   wife
		表中实现有2种方法：共享主键  唯一外键【推荐】		
	
	
	类中如何表示
		public class Husband{
			private Wife wife;
		}
		
		public class Wife{
			private Husband husband;
		}	
	
	共享主键
		create table t_hus(
			id number(18) primary key,
			name varchar2(20) not null
		);
		
		create sequence seq_hus;

		create table t_wife(
			id number(18) primary key,
			name varchar2(20) not null,
			foreign key(id) references t_hus(id)
		);
		
		对应的映射元文件
		<class name="Husband" table="T_HUS" schema="YANJUN">
				<one-to-one name="wife" class="Wife" cascade="all"></one-to-one>
		</class>
		
		
		<class name="Wife" table="T_WIFE" schema="YANJUN">
			<id name="id" type="java.lang.Long">
				<column name="ID" precision="18" scale="0" />
				<generator class="foreign">
					<param name="property">husband</param>
				</generator>
			</id>
			<one-to-one name="husband" class="Husband" constrained="true"></one-to-one>		
		</class>
	
		constrained="true"表示当前类属于受控方
	-------------------------------------------------------------------------------------
	唯一外键   Person  IdCard
	
		create table t_person(
			id number(18) primary key,
			username varchar2(20)
		);
		
		create sequence seq_person;
		
		create table t_card(
			id number(18) primary key,
			card_no varchar2(18),
			person_id number(18) not null unique, --重点
			foreign key(person_id) references t_person(id)
		);
	
		create sequence seq_card;						
		
		<class name="Person" table="T_PERSON" schema="YANJUN">
			<one-to-one name="idCard" property-ref="person" cascade="all"/>
		</class>
		
		<class name="IdCard" table="T_CARD">
			<many-to-one name="person" column="person_id" unique="true" not-null="true" />
		</class>
		
======================================================================================================
1:n		roles   users
	
  	
	
	create table t_roles(
		id number(18) primary key,
		name varchar2(20)
	);
	create sequence seq_roles;
	
	create table t_users(
		id number(18) primary key,
		userame varchar2(20),
		role_id number(18),
		foreign key(role_id) references t_roles(id)
	);
	create sequence seq_users;
	
	<class name="Role" table="T_ROLES" schema="YANJUN">		
		<set name="users" inverse="true" cascade="all">
			<key>
				<column name="ROLE_ID" precision="18" scale="0" />
			</key>
			<one-to-many class="User" />
		</set>
	</class>
		public class Role implements java.io.Serializable {
     		private Set users = new HashSet(0);
    	}
		
	<class name="User" table="T_USERS" schema="YANJUN">      
        <many-to-one name="role" class="Role" fetch="join">
            <column name="ROLE_ID" precision="18" scale="0" />
        </many-to-one>        
    </class>
		public class User implements java.io.Serializable {
  	 		  private Role role;
  		}  		
======================================================================================================	
n:m   无法直接表示，必须通过中间表表示[中间表中不能包含非键列]
	Student Course
	
	create table t_student(
		id number(18) primary key,
		name varchar2(20)
	);
	create sequence seq_student;
	
	create table t_course(
		id number(18) primary key,
		title varchar2(32)
	);
	create sequence seq_course;
	
	create table stu_cour(
		stu_id number(18),
		cour_id number(18),
		primary key(stu_id,cour_id),
		foreign key(stu_id) references t_student(id),
		foreign key(cour_id) references t_course(id)
	);
	
	<class name="Course" table="T_COURSE">        
        <set name="students" inverse="true" cascade="all" table="STU_COUR中间表">
            <key>
                <column name="COUR_ID" precision="18" scale="0" not-null="true" />
            </key>
            <many-to-many entity-name="com.yan.entity.many2many.Student">
                <column name="STU_ID" precision="18" scale="0" not-null="true" />
            </many-to-many>
        </set>
    </class>
    	public class Course  implements java.io.Serializable {
		     private Set students = new HashSet(0);
		}
		
	<class name="Student" table="T_STUDENT">       
        <set name="courses" table="STU_COUR">
            <key>
                <column name="STU_ID" precision="18" scale="0" not-null="true" />
            </key>
            <many-to-many entity-name="com.yan.entity.many2many.Course">
                <column name="COUR_ID" precision="18" scale="0" not-null="true" />
            </many-to-many>
        </set>
    </class>
    	public class Student  implements java.io.Serializable {
		     private Set courses = new HashSet(0);
		}
======================================================================================================		
	自关联:
		图书馆的分类
		
		1   计算机图书   null
		2   硬件图书      1
		3   软件图书      1
		4   CPU相关图书   2
		5   8086系列      4
		
		create table t_catalog(
			id number(18) primary key,
			title varchar2(32) not null,
			parent_id number(18),
			foreign key(parent_id) references t_catalog(id)
		);
		create sequence seq_catalog;
		
		
		<class name="Catalog" table="T_CATALOG">
        	<many-to-one name="parent" class="Catalog" fetch="select">
            	<column name="PARENT_ID" precision="18" scale="0" />
        	</many-to-one>
            <set name="children" inverse="true" cascade="save-update">
	            <key>
	                <column name="PARENT_ID" precision="18" scale="0" />
	            </key>
	            <one-to-many class="Catalog" />
        	</set>
   		</class>
   		
   		遍历需要使用递归调用    	     
    
	
======================================================================================================	
类之间的关系：
	继承   在表中如何实现   有3种方法
	
	整个继承树对应一个表
		Animal动物【id,name】    Cat猫[color]    Dog[catalog]
		
		create table t_animal(
			id number(18) primary key,
			name varchar2(32),
			color varchar2(10),---不管业务规则如何，这里一定允许为空,dog就没有属性
			catalog varchar2(20),---不管业务规则如何，这里一定允许为空,cat就没有属性
			dicrn varchar2(10)  ---特殊列用于区分不同类别的数据
		); 
		create sequence seq_animal;
		
		1  zhangsan         	animal
		2  小白   黑色       	cat
		3  小黑         腊肠  	dog
		
		类继承树肯定是对应多个类，要把多个类的信息存放在一张表中，必须有某种机制来区分哪些记录是属于哪个类的。 
		这种机制就是，在表中添加一个字段[dicrn]，用这个字段的值来进行区分
		
		<class name="Animal" table="T_ANIMAL" discriminator-value="111">  discriminator-value="111"用于决定描述列中存储的具体数据   
			<id name="id" type="java.lang.Long">
				<column name="ID" precision="18" scale="0" />
				<generator class="sequence"></generator>
			</id>
			<discriminator column="dicrn" length="10" type="string" />  定义特殊的描述列，用于区分一行数据的具体类型
			<property name="name" type="java.lang.String">
				<column name="NAME" length="32" />
			</property>
			<subclass name="Cat" discriminator-value="cat">
				<property name="color" type="java.lang.String">
					<column name="COLOR" length="10" />
				</property>
			</subclass>
			<subclass name="Dog" discriminator-value="dog">
				<property name="catalog" type="java.lang.String">
					<column name="CATALOG" length="20" />
				</property>
			</subclass>
		</class>
		
		优点
			实现简单
			支持多态——对象角色发生变化，或存在多重角色时
				from Animal可以查询到Animal  Dog和Cat
					from Object
			报表操作实现简单：表中包含了所有信息
		
		缺点
			增加类层次中的耦合。类层次中任何类的属性的增加都会导致表的变更；某个子类属性的修改会影响到整个层次结构，而不仅仅是该子类
			浪费了一些数据库空间。浪费空间的多少取决于继承层次的深度。层次越深，不同的属性越多，属性的全集就越大，也就越浪费空间
			可能需要指明具体的角色
	----------------------------------------------------------------------------------------------
		继承关系树的每个具体类对应一张表：在具体类对应的表中，不仅包含和具体类属性对应的字段，还包括与具体类的父类属性对应的字段
			Man人类[id,name]  Stu学生[score]  Tea教师[salary]
			
			create table t_stu(
				id int primary key,
				name varchar2(10 char),
				score number(3,1)
			);	
			
			create table t_tea(
				id int primary key,
				name varchar2(10 char),
				salary number(6,2)
			);
			两张表中的id不能重复，因为可能有需求为加载1号人
			
			优点
				报表操作实现简单：表中包含了具体子类的所有信息
			
			缺点
				父类的修改会导致子类所对应表的更改
				当含有多重子类时，会造成在数据库表格中生成重复的字段 
				
	----------------------------------------------------------------------------------------------
		继承关系树中的每个类对应一张表，每个表中只包括和这个类本身属性对应的字段，子类的表参照父类对应的表
			交通工具[id,name]   小轿车[载客人数]   卡车[载重量]
		
			create table t_jiaotong(
				id number(18) primary key,
				name varchar2(20) 
			);
			
			create sequence seq_jiaotong;
			
			create table t_jiaoche(
				id number(18) primary key,
				zaike number(3),
				foreign key(id) references t_jiaotong(id)
			);
			
			create table t_kache(
				id number(18) primary key,
				zaikong number(3,1),
				foreign key(id) references t_jiaotong(id)
			);
					
	
 			<class name="Jiaotong" table="T_JIAOTONG">
				<id name="id" type="java.lang.Long">
					<column name="ID" precision="18" scale="0" />
					<generator class="sequence">
						<param name="sequence">seq_jiaotong</param>
					</generator>
				</id>
				<property name="name" type="java.lang.String">
					<column name="NAME" length="20" />
				</property>
				<joined-subclass name="Jiaoche" table="t_jiaoche">
					<key column="id"></key>
					<property name="zaike" type="java.lang.Integer">
						<column name="zaike" precision="3" scale="0" />
					</property>
				</joined-subclass>
				<joined-subclass name="Kache" table="t_keche">
					<key column="id"></key>
					<property name="zaizhong" type="java.lang.Double">
						<column name="zaikong" precision="3" scale="1" />
					</property>
				</joined-subclass>
			</class>
			
		优点
			与面向对象的概念的一致性最好。对多态的支持最好，对于对象所可能充当的角色仅需要在相应的表中保存记录
			易于修改基类和增加新的类
			这种映射几乎有最佳的空间节约性。唯一的容易就是额外的OID，来连接不同的层级层次
	
		缺点
			数据库中存在大量的表
			访问数据的时间较长。在读写相关的任务上，这种映射方式相当费资源，这个代价还随着继承层次的增多而增大
			对报表的支持较差，除非定义视图
