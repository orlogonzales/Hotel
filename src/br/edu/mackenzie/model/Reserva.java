package br.edu.mackenzie.model;

public class Reserva {
	/*#RESERVA:
		#CHECK-IN
		#CHECK-OUT
		#*QUARTO
		# ARRUMAR ESSA TABLE!!!!!!


		CREATE  TABLE `hotel_db`.`reserva_tb` (
		  `id` INT NOT NULL ,
		  `reserva` DATE NULL ,
		  `periodoDias` INT NULL ,
		  PRIMARY KEY (`id`) ,
		  INDEX `fk_quarto` (`id` ASC) ,
		  CONSTRAINT `fk_quarto`
		    FOREIGN KEY (`id` )
		    REFERENCES `hotel_db`.`quarto_tb` (`id` ))
		DEFAULT CHARACTER SET = utf8;
*/
}
