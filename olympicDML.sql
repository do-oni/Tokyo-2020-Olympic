-- player insert[����]
insert into player values('1', '���м�', '30', '���ѹα�','ü��');
insert into player values('2', '�Ȼ�', '21', '���ѹα�', '���');
insert into player values('3', '�迬��', '33', '���ѹα�', '�豸');
insert into player values('4','��� ��������','35','�̱�','�߱�');
insert into player values('5','����Ŭ ������','36','�̱�','����');
insert into player values('6','������','21','�߱�','����');


-- sport insert[����]
insert into sport values('ü��', '���ѹα�', '5');
insert into sport values('���', '���ѹα�', '3');
insert into sport values('�豸', '���ѹα�', '0');
insert into sport values('�߱�', '�̱�', '1');
insert into sport values('����', '�̱�', '3');
insert into sport values('����', '�߱�', '8');


-- medal insert[�޴� ����]
insert into medal values('kg','���ѹα�','ü��','1','0','0');
insert into medal values('ka','���ѹα�','���','0','1','2');
insert into medal values('kv','���ѹα�','�豸','0','0','0');
insert into medal values('ab','�̱�','�߱�','0','1','0');
insert into medal values('as','�̱�','����','4','0','0');
insert into medal values('cw','�߱�','����','7','0','1');


-- olympic insert[�ø���]
insert into olympic values(olympic_id_seq.nextval, '���ѹα�', 'ü��', '1','kg');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '���ѹα�', '���', '2','ka');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '���ѹα�', '�豸', '3','kv');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '�̱�', '�߱�', '4','ab');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '�̱�', '����', '5','as');
insert into OLYMPIC values(OLYMPIC_ID_seq.nextval, '�߱�', '����', '6','cw');
commit;
