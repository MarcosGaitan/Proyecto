
/* MESAS*//* MESAS*/
	insert into mesa values (1, 2, 1, 'libre');
    insert into mesa values (2, 2, 2, 'libre');
    insert into mesa values (3, 2, 3, 'libre');
    insert into mesa values (4, 2, 4, 'libre');
    insert into mesa values (5, 2, 5, 'libre');
    insert into mesa values (6, 2, 6, 'libre');
    insert into mesa values (7, 2, 7, 'libre');
    insert into mesa values (8, 2, 8, 'libre');
    insert into mesa values (9, 2, 9, 'libre');
    insert into mesa values (10, 2, 10, 'libre');
    insert into mesa values (11, 2, 11, 'libre');
    insert into mesa values (12, 2, 12, 'libre');
  
  
/* TIPOCLIENTE*/
	insert into tipoCliente values (1, 'individual');
    insert into tipoCliente values(2, 'corportativo');
    
/* TIPO EMPLEADO */ 
	insert into tipoEmpleado values(1,'admin');
    insert into tipoEmpleado values(2, 'Gerente');
    insert into tipoEmpleado values(3, 'Camarero');
    insert into tipoEmpleado values(4, 'JefeSalon');
    
/** USUARIOS**/
	/** EL SUPER ADMIN   **/
	insert into Persona values (1, 'admin@hotmail.com', 'admin', 'admin',11111111);

	/** CLIENTES  (9  personas) **/ 
    
		/* comunes*/
		insert into Persona values (2, 'clienteA@hotmail.com','clienteA', 'clienteA', 22222222 );
		insert into Persona values (3, 'clienteB@hotmail.com','clienteB', 'clienteB', 33333333);
		insert into Persona values (4,'clienteC@hotmail.com','clienteC', 'clienteC', 44444444);
		insert into Persona values (5,'clienteD@hotmail.com','clienteD', 'clienteD', 55555555);
		insert into Persona values (6,'clienteE@hotmail.com','clienteE', 'clienteE', 66666666);
        
        /* corpórativos */ 
		insert into Persona values (7,'clienteF@hotmail.com','clienteF', 'clienteF',77777777);
		insert into Persona values (8,'clienteG@hotmail.com','clienteG', 'clienteG',88888888);
		insert into Persona values (9,'clienteH@hotmail.com','clienteH','clienteH',99999999);
		insert into Persona values (10,'clienteI@hotmail.com','clienteI', 'clienteI',10101010);

	 /* EMPLEADOS (5 personas) */ 
	insert into Persona values (11,'GerenteA@hotmail.com','GerenteA', 'GerenteA',12121212);
	insert into Persona values (12,'CamareroA@hotmail.com','CamareroA', 'CamareroA',13131313);
	insert into Persona values (13,'CamareroB@hotmail.com','CamareroB', 'CamareroB',14141414);
	insert into Persona values (14,'CamareroC@hotmail.com','CamareroC', 'CamareroC',15151515);
	insert into Persona values (15,'JefeSalonA@hotmail.com','JefeSalonA', 'JefeSalonA',16161616);
	
    /* Clasificar los usuarios*/
		/* Los Empleados*/
		insert into empleado values (1, 1, 'admin', 'admin', true );
        insert into empleado values (11, 2, 'empleadoA', '1234', true);
        insert into empleado values (12, 3, 'empleadoB', '1234', true);
        insert into empleado values (13, 3, 'empleadoC', '1234', true);
        insert into empleado values (14, 3, 'empleadoD', '1234', true);
        insert into empleado values (15, 4, 'empleadoE', '1234', true);
		
        /* los clientes */
		insert into cliente values (2, 1);
		insert into cliente values (3, 1);
		insert into cliente values (4, 1);
		insert into cliente values (5, 1);
		insert into cliente values (6, 2);
		insert into cliente values (7, 2);
		insert into cliente values (8, 2);
		insert into cliente values (9, 2);
		insert into cliente values (10, 2);

/* RUBRO */
	insert into rubro values(1, 'entrada');
    insert into rubro values(2, 'principal');
    insert into rubro values(3, 'postre');
    insert into rubro values(4, 'minuta');
    insert into rubro values(5, 'bebida');
/* SUBRUBRO*/  
	insert into subRubro values(1, 'carne');
    insert into subRubro values(2, 'pescado');
    insert into subRubro values(3, 'pastas');
    insert into subRubro values(4, 'sandwiches');
    insert into subRubro values(5, 'tartas');
    insert into subRubro values(6, 'con alcohol');
    insert into subRubro values(7, 'sin alcochol');
    insert into subRubro values(8, 'light');
    insert into subRubro values(9, 'clasico');

/* STOCK */
	insert into stock values(1, 900.0, 200.0, 500.0);
    insert into stock values(2, 900.0, 200.0, 500.0);
    insert into stock values(3, 900.0, 200.0, 500.0);
    insert into stock values(4, 900.0, 200.0, 500.0);
    insert into stock values(5, 900.0, 200.0, 500.0);
    insert into stock values(6, 900.0, 200.0, 500.0);
    insert into stock values(7, 900.0, 200.0, 500.0);
    insert into stock values(8, 900.0, 200.0, 500.0);
    insert into stock values(9, 900.0, 200.0, 500.0);
    insert into stock values(10, 900.0, 200.0, 500.0);
    insert into stock values(11, 90.0, 20.0, 50.0);
    insert into stock values(12,90.0, 20.0, 50.0);
    insert into stock values(13, 90.0, 20.0, 50.0);
    insert into stock values(14, 90.0, 20.0, 50.0);
    insert into stock values(15, 90.0, 20.0, 50.0);
    insert into stock values(16, 90.0, 20.0, 50.0);

/* INGREDIENTES*/
	insert into ingrediente values(1, 'ingrediente 1', 1);
    insert into ingrediente values(2, 'ingrediente 2', 2);
    insert into ingrediente values(3, 'ingrediente 3', 3);
    insert into ingrediente values(4, 'ingrediente 4', 4);
    insert into ingrediente values(5, 'ingrediente 5', 5);
    insert into ingrediente values(6, 'ingrediente 6', 6);
    insert into ingrediente values(7, 'ingrediente 7', 7);
    insert into ingrediente values(8, 'ingrediente 8', 8);
    insert into ingrediente values(9, 'ingrediente 9', 9);
    insert into ingrediente values(10, 'ingrediente 10', 10);
     insert into ingrediente values(11, 'ingrediente 10', 11);

/* PRODUCTOS*/
	insert into producto values(1, 'productoA', 'A- carne asada', null, 1, 1);
    insert into producto values(2, 'productoB', 'B- pesacado al horno', null, 1, 2);
    insert into producto values(3, 'productoC', 'C- carne al horno', null, 2, 1);
    insert into producto values(4, 'productoD', 'D- pescado asado', null, 2, 2);
    insert into producto values(5, 'productoE', 'E- pasta especial', null, 2, 3);
    insert into producto values(6, 'productoF', 'F- de jamon y queso chedar', null, 2, 4);
    insert into producto values(7, 'productoG', 'G- postre Atomico ', null, 3, 8);
    insert into producto values(8, 'productoH', 'H- postre Bermellon', null, 3, 9);
    insert into producto values(9, 'productoI', 'I- postre Celula', null, 3, 9);
    insert into producto values(10, 'productoJ', 'J- minuta carnivora', null, 4, 1);
    insert into producto values(11, 'productoK', 'k- minuta redonda', null, 4, 5);
    insert into producto values(12, 'productoL', 'l- bebida con alcochol etilico', null, 5, 1);
    insert into producto values(13, 'productoM', 'm- bebida con alcochol de vainilla', null, 5, 1);
    insert into producto values(14, 'productoN', 'n- bebida sin alcochol espumozo', null, 5, 2);
    insert into producto values(15, 'productoO', 'o- bebida sin alcohol roja', null, 5, 2);
    insert into producto values(16, 'productoP', 'P- bebida sin alcohol azul', null, 5, 2);

/* PLATOS*/ 
	insert into plato values(1);
    insert into plato values(2);
    insert into plato values(3);
    insert into plato values(4);
    insert into plato values(5);
    insert into plato values(6);
    insert into plato values(7);
    insert into plato values(8);
    insert into plato values(9);
    insert into plato values(10);
    insert into plato values(11);
    
		/*plato Ingrediente..  la mas heavy*/
		insert into platoIngrediente values(1, 1, 1, 50.0);
		insert into platoIngrediente values(2, 1, 2, 50.0);
		insert into platoIngrediente values(3, 1, 3, 50.0);
		insert into platoIngrediente values(4, 1, 4, 50.0);
		
		insert into platoIngrediente values(5, 2, 2, 50.0);
		insert into platoIngrediente values(6, 2, 3, 50.0);
		insert into platoIngrediente values(7, 2, 4, 50.0);
		
		insert into platoIngrediente values(8, 3, 3, 50.0);
		insert into platoIngrediente values(9, 3, 4, 50.0);
		insert into platoIngrediente values(10, 3, 5, 50.0);
		insert into platoIngrediente values(11, 3, 6, 50.0);
		
		insert into platoIngrediente values(12, 4, 4, 50.0);
		insert into platoIngrediente values(13, 4, 5, 50.0);
		insert into platoIngrediente values(14, 4, 6, 50.0);
		
		insert into platoIngrediente values(15, 5, 5, 50.0);
		insert into platoIngrediente values(16, 5, 6, 50.0);
		insert into platoIngrediente values(17, 5, 7, 50.0);
		
		insert into platoIngrediente values(18, 6, 5, 50.0);
		insert into platoIngrediente values(19, 6, 6, 50.0);
		insert into platoIngrediente values(20, 6, 7, 50.0);
		insert into platoIngrediente values(21, 6, 8, 50.0);
		
		insert into platoIngrediente values(22, 7, 4, 50.0);
		insert into platoIngrediente values(23, 7, 5, 50.0);
		insert into platoIngrediente values(24, 7, 6, 50.0);
		
		insert into platoIngrediente values(25, 8, 5, 50.0);
		insert into platoIngrediente values(26, 8, 6, 50.0);
		insert into platoIngrediente values(27, 8, 7, 50.0);
		
		insert into platoIngrediente values(28, 9, 5, 50.0);
		insert into platoIngrediente values(29, 9, 6, 50.0);
		insert into platoIngrediente values(30, 9, 7, 50.0);
		insert into platoIngrediente values(31, 9, 8, 50.0);
		
		insert into platoIngrediente values(32, 10, 8, 50.0);
		insert into platoIngrediente values(33, 10, 9, 50.0);
		insert into platoIngrediente values(34, 10, 10, 50.0);
		
		insert into platoIngrediente values(35, 11, 1, 50.0);
		insert into platoIngrediente values(36, 11, 3, 50.0);
		insert into platoIngrediente values(37, 11, 10, 50.0);
        insert into platoIngrediente values(38, 11, 11, 50.0);
    
    
/* BEBIDAS*/
	insert into bebida values(12, 1.0, 12);
    insert into bebida values(13, 1.5, 12);
    insert into bebida values(14, 0.5, 13);
    insert into bebida values(15, 1.0, 15);
    insert into bebida values(16, 1.0, 16);
    

/*************    LA PARTE DE LOS MENUS LOKOS         *********/

	/* Lista precio */
	insert into listaPrecio values (1, '2017-05-01 10:00:00', '2017-07-01 18:00:00');
	
		/* itemListaPrecio*/
		insert into itemlistaprecio values(1, 1, 1);
        insert into itemlistaprecio values(2, 2, 1);
        insert into itemlistaprecio values(3, 3, 1);
        insert into itemlistaprecio values(4, 4, 1);
        insert into itemlistaprecio values(5, 5, 1);
        insert into itemlistaprecio values(6, 6, 1);
        insert into itemlistaprecio values(7, 7, 1);
        insert into itemlistaprecio values(8, 8, 1);
        insert into itemlistaprecio values(9, 9, 1);
        insert into itemlistaprecio values(10, 10, 1);
        insert into itemlistaprecio values(11, 11, 1);
        insert into itemlistaprecio values(12, 12, 1);
        insert into itemlistaprecio values(13, 13, 1);
        insert into itemlistaprecio values(14, 14, 1);
        insert into itemlistaprecio values(15, 15, 1);
        insert into itemlistaprecio values(16, 16, 1);
		
			/* precio Tipo Cliente*/
            
            /* cliente comun o individual*/
			insert into precioTipoCliente values(1, 1,1, 15.0);
            insert into precioTipoCliente values(2, 2,1, 14.0);
            insert into precioTipoCliente values(3, 3,1, 25.0);
            insert into precioTipoCliente values(4, 4,1, 34.0);
            insert into precioTipoCliente values(5, 5,1, 45.0);
            insert into precioTipoCliente values(6, 6,1, 26.0);
            insert into precioTipoCliente values(7, 7,1, 32.0);
            insert into precioTipoCliente values(8, 8,1, 48.0);
            insert into precioTipoCliente values(9, 9,1, 47.0);
            insert into precioTipoCliente values(10, 10,1, 65.0);
            insert into precioTipoCliente values(11, 11,1, 35.0);
            insert into precioTipoCliente values(12, 12,1,55.0);
            insert into precioTipoCliente values(13, 13,1, 59.0);
            insert into precioTipoCliente values(14, 14,1, 78.0);
            insert into precioTipoCliente values(15, 15,1, 62.0);
            insert into precioTipoCliente values(16, 16,1, 35.0);
			
            /*cleinte corporativo*/
			insert into precioTipoCliente values(17, 1, 2, 12.0);
            insert into precioTipoCliente values(18, 2, 2, 11.0);
            insert into precioTipoCliente values(19, 3, 2, 21.0);
            insert into precioTipoCliente values(20, 4, 2, 30.0);
            insert into precioTipoCliente values(21, 5, 2, 40.0);
            insert into precioTipoCliente values(22, 6, 2, 20.0);
            insert into precioTipoCliente values(23, 7, 2, 25.0);
            insert into precioTipoCliente values(24, 8, 2, 44.0);
            insert into precioTipoCliente values(25, 9, 2, 42.0);
            insert into precioTipoCliente values(26, 10, 2, 60.0);
            insert into precioTipoCliente values(27, 11, 2, 30.0);
            insert into precioTipoCliente values(28, 12, 2, 50.0);
            insert into precioTipoCliente values(29, 13, 2, 55.0);
            insert into precioTipoCliente values(30, 14, 2, 70.0);
            insert into precioTipoCliente values(31, 15, 2, 55.0);
            insert into precioTipoCliente values(32, 16, 2, 30.0);
        
	/* Menu   */   
	insert into menu values (1, 'menu master', 1);	
    
    /* *productos en Menu */
		insert into productoMenu values(1, 1, 1, true);
		insert into productoMenu values(2, 1, 2, true);
		insert into productoMenu values(3, 1, 3, true);
		insert into productoMenu values(4, 1, 4, true);
		insert into productoMenu values(5, 1, 5, true);
		
		insert into productoMenu values(6, 1, 6, true);
		insert into productoMenu values(7, 1, 7, true);
		insert into productoMenu values(8, 1, 8, true);
		insert into productoMenu values(9, 1, 9, true);
		insert into productoMenu values(10, 1, 10, true);
		
		insert into productoMenu values(11, 1, 11, true);
		insert into productoMenu values(12, 1, 12, true);
		insert into productoMenu values(13, 1, 13, true);
		insert into productoMenu values(14, 1, 14, true);
		insert into productoMenu values(15, 1, 15, true);
		insert into productoMenu values(16, 1, 16, true);
	
/********* Comada de prueba **********/

insert into mesaFinal values(1, 2, false,'mesa de Prueba',now(), now());

insert into mesaArmada values(1,1);
insert into mesaArmada values(2,1);

insert into comanda values(1, true, true, false, null, now(), 1, 2, 12);

insert into comandaItem values(1, 1, 1, 15.0, 1);
insert into comandaItem values(2, 2, 1, 14.0, 1);
insert into comandaItem values(3, 3, 1, 25.0, 1);
insert into comandaItem values(4, 4, 1, 34.0, 1);


insert into ticket values( 1, 100.50, true, true, now(), true, 'de la Casa', 11, 1);


/******* Nuevas Comandas De Prueba *******/
insert into comanda values(2, true, true, false, null, now(), 1, 2, 12);

insert into comandaItem values(5, 1, 2, 30.0, 2);
insert into comandaItem values(6, 2, 2, 14.0, 1);
insert into comandaItem values(7, 3, 2, 75.0, 3);

insert into comanda values(3, true, true, false, null, now(), 1, 2, 12);
insert into comandaItem values(8, 1, 3, 30.0, 2);
insert into comandaItem values(9, 2, 3, 28.0, 2);
insert into comandaItem values(10, 3, 3, 50, 2);

insert into comanda values(4, true, true, false, null, now(), 2, 2, 12);
insert into comandaItem values(11, 1, 4, 30.0, 2);
insert into comandaItem values(12, 2, 4, 28.0, 2);
insert into comandaItem values(13, 3, 4, 50, 2);
