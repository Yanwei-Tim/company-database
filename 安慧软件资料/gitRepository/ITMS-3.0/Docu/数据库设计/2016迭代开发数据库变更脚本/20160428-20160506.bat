@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl

sqlplus %user%/%password%@%oranetname% @9_20160428/1_Υ�����ɱ���.sql
sqlplus %user%/%password%@%oranetname% @9_20160428/2_������־����.sql
sqlplus %user%/%password%@%oranetname% @10_20160504/1_ϵͳ�����ϱ�ͽ�ɫ����.sql
sqlplus %user%/%password%@%oranetname% @10_20160504/2_�������.sql
sqlplus %user%/%password%@%oranetname% @11_20160506/1_ͳ��������.sql
sqlplus %user%/%password%@%oranetname% @11_20160506/2_ϵͳ����͹��ܲ˵�.sql
sqlplus %user%/%password%@%oranetname% @11_20160506/3_�����ݱ���.sql


@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
