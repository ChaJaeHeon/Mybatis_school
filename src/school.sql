--�л� ���� ���̺�
create table student (
	name    varchar2(20)  not null, --�л��̸�
	id      varchar2(20)  primary key, --�й�
	phone 	varchar2(30),				--��ȭ��ȣ
	kor     number(3) default 0,		--��������
	eng     number(3) default 0, 		--��������
	mat     number(3) default 0 		--��������
);

-- ���� ��
insert into student values ('ȫ�浿', '1111', '010-1111-1111', 90, 80, 70);