set define off
spool 2_1_ȡ��·�α�·�δ���ΨһԼ��.log

alter table T_SYS_ROAD_SECTION
  drop constraint ROAD_SECTION_CODE_UNIQUE cascade;
  
spool off

exit;