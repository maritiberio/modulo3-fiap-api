package br.com.fiap.abctechapi.repository;


import br.com.fiap.abctechapi.controller.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance, Long> {

}
