LudoM version 1.0.1

Requisitos de instalacion: 
		-Tener Java instalado en tu computadora (Java Runtime Environment)

Instrucciones de ejecucion: 
		- Click derecho sobre el archivo LudoM1.0.1.jar
		- Click en Open

Bugs conocidos:
	Defectos conocidos:

-Existe la posibilidad de que el dado sea 6 en la primera jugada, esto hace que el observer aún no se registre en el hilo de la vista y en consecuencia, la primera jugada no se refleja. No genera problemas más graves que eso y en la 2da ya funciona normalmente.
	
-Al utilizar concurrencia, cuando tenía un refresco constante de los datos mostrados se generaba se generaba un deadLock por el interleaving del frontend y backend, esto se soluciono cuando la actualización la lleva a cabo el observer, sin embargo no se descarta que exista una pequeña probabilidad de que se de nuevamente.

-El hecho de que no se muestre el ganador, es un requerimiento no funcional asi que debería ser agregado en futuras versiones.
