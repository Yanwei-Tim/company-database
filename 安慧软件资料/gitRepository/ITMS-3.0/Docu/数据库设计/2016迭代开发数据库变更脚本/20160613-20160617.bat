@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl

sqlplus %user%/%password%@%oranetname% @22_20160613/1_Ԥ��λ����.sql
sqlplus %user%/%password%@%oranetname% @23_20160616/1_�������ż�¼��.sql
sqlplus %user%/%password%@%oranetname% @24_20160617/1_ϵͳ�������.sql
sqlplus %user%/%password%@%oranetname% @24_20160617/2_ϵͳ����.sql
sqlplus %user%/%password%@%oranetname% @24_20160617/3_���ܲ˵�.sql
sqlplus %user%/%password%@%oranetname% @24_20160617/4_�豸��������.sql
sqlplus %user%/%password%@%oranetname% @24_20160617/5_�û������.sql



@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
