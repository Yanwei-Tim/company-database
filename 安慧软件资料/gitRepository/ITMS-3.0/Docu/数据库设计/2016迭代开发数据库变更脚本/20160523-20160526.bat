@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl

sqlplus %user%/%password%@%oranetname% @16_20160523/1_ϵͳ����.sql
sqlplus %user%/%password%@%oranetname% @17_20160525/1_�춨��ر�����Ψһ����.sql
sqlplus %user%/%password%@%oranetname% @17_20160525/2_Υ�����ɱ���������.sql
sqlplus %user%/%password%@%oranetname% @17_20160525/3_Ѳ����־����.sql
sqlplus %user%/%password%@%oranetname% @18_20160526/1_ϵͳ�������.sql
sqlplus %user%/%password%@%oranetname% @18_20160526/2_���ܲ˵�.sql


@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
