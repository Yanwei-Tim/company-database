@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl

sqlplus %user%/%password%@%oranetname% @2_20160414/1_ȡ��·�α�·�δ���ΨһԼ��.sql
sqlplus %user%/%password%@%oranetname% @3_20160419/1_��ƵѲ����־�����ӻ���ID.sql
sqlplus %user%/%password%@%oranetname% @4_20160420/1_�춨�������.sql
sqlplus %user%/%password%@%oranetname% @4_20160420/2_�����������ϵͳ.sql
sqlplus %user%/%password%@%oranetname% @5_20160421/1_�豸�������Ӻ�ͬ����.sql
sqlplus %user%/%password%@%oranetname% @5_20160421/2_���Ӽ춨��ͳ����ͼ.sql
sqlplus %user%/%password%@%oranetname% @5_20160421/3_���ӵ����.sql
sqlplus %user%/%password%@%oranetname% @5_20160421/4_����ά������.sql
sqlplus %user%/%password%@%oranetname% @5_20160421/5_ϵͳ����.sql
sqlplus %user%/%password%@%oranetname% @6_20160422/1_���ܲ˵�.sql
sqlplus %user%/%password%@%oranetname% @6_20160422/2_�����������ܿ�ƽ̨����켣��.sql
sqlplus %user%/%password%@%oranetname% @7_20160426/1_5������������������.sql
sqlplus %user%/%password%@%oranetname% @8_20160427/1_�����ֶ�.sql
sqlplus %user%/%password%@%oranetname% @8_20160427/2_������־����.sql
sqlplus %user%/%password%@%oranetname% @8_20160427/3_Υ�����������.sql

@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
