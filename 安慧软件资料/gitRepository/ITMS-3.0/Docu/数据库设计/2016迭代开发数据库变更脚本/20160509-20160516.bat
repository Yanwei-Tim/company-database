@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl

sqlplus %user%/%password%@%oranetname% @12_20160509/1_��������ǰ׺��.sql
sqlplus %user%/%password%@%oranetname% @13_20160510/1_�豸�������ü�¼.sql
sqlplus %user%/%password%@%oranetname% @13_20160510/2_Υ�����ɳ�������.sql
sqlplus %user%/%password%@%oranetname% @13_20160510/3_�豸״̬ͳ���м����.sql
sqlplus %user%/%password%@%oranetname% @13_20160510/4_������ͳ�ƴ洢����.sql
sqlplus %user%/%password%@%oranetname% @13_20160510/ϵͳ����.sql
sqlplus %user%/%password%@%oranetname% @14_20160513/1_�޸�Υ�����ɳ�����.sql
sqlplus %user%/%password%@%oranetname% @15_20160516/1_����������.sql
sqlplus %user%/%password%@%oranetname% @15_20160516/2_�˵��빦��.sql

@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
