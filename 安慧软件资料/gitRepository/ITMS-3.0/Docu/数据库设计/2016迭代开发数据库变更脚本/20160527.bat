@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl

sqlplus %user%/%password%@%oranetname% @16_20160527/1_Υ�����ɱ���.sql

@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
