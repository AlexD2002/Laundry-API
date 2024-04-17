package com.laundry.Test.maquinas;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long>{

	List<Maquina> findAllByActiveTrue();

}
