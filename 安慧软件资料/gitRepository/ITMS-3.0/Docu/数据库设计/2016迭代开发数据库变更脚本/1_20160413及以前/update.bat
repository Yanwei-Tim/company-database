@echo off
::�û���
set user=itms3
::�û�����
set password=itms3
::���ݿ�������
set oranetname=127.0.0.1/orcl
sqlplus %user%/%password%@%oranetname% @1_��������켣�����ű�.sql
sqlplus %user%/%password%@%oranetname% @2_�豸��·����������ű�.sql
sqlplus %user%/%password%@%oranetname% @3_�û�ǩ�½ű�.sql
sqlplus %user%/%password%@%oranetname% @4_��ƵѲ�����.sql
sqlplus %user%/%password%@%oranetname% @5_ƽ̨��ҳ.sql
sqlplus %user%/%password%@%oranetname% @6_�豸��װ�����Ӽ춨��ʶ.sql
sqlplus %user%/%password%@%oranetname% @7_�豸��װ����ͼ���.sql
sqlplus %user%/%password%@%oranetname% @8_��Ƶ���뷽ʽ����.sql
sqlplus %user%/%password%@%oranetname% @9_ϵͳ�û���½ͳ��.sql
sqlplus %user%/%password%@%oranetname% @10_�̶�����ϵͳ�������Ƶ���.sql
sqlplus %user%/%password%@%oranetname% @11_�춨������ر���.sql
sqlplus %user%/%password%@%oranetname% @12_�����Ƴ����.sql
sqlplus %user%/%password%@%oranetname% @98_ϵͳ����.sql
sqlplus %user%/%password%@%oranetname% @99_����Ȩ�޲˵�.sql
@ECHO.
@ECHO Completed
@ECHO.
pause
@echo on
