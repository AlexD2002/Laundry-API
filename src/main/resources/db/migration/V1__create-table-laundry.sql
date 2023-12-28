create table laundry(
   id bigint not null auto_increment,
   nome varchar (100) not null,
   estado varchar (100) not null,
   quantidade int (20) not null,
   site varchar (100) not null,
  
   primary key (id)
);