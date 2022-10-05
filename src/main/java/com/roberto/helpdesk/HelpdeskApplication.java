package com.roberto.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roberto.helpdesk.domain.Chamado;
import com.roberto.helpdesk.domain.Cliente;
import com.roberto.helpdesk.domain.Tecnico;
import com.roberto.helpdesk.domain.enums.Perfil;
import com.roberto.helpdesk.domain.enums.Prioridade;
import com.roberto.helpdesk.domain.enums.Status;
import com.roberto.helpdesk.repositories.ChamadoRepository;
import com.roberto.helpdesk.repositories.ClienteRepository;
import com.roberto.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tec1 = new Tecnico(null, "Matheus Brito", "829.711.280-24", "matheus@mail.com", "123");
		Cliente cli1 = new Cliente(null, "Roberto Bruno", "723.708.280-99", "roberto@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));

	}

}
