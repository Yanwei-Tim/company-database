set define off
spool 8_��Ƶ���뷽ʽ����.log

 update t_sys_code_type c set c.code_type_name = '��Ƶ���뷽ʽ' where c.code_type = '485';
 
 commit;
 
 
spool off

exit;