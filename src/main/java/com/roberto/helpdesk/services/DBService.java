package com.roberto.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.helpdesk.domain.Chamado;
import com.roberto.helpdesk.domain.Cliente;
import com.roberto.helpdesk.domain.Tecnico;
import com.roberto.helpdesk.domain.enums.Perfil;
import com.roberto.helpdesk.domain.enums.Prioridade;
import com.roberto.helpdesk.domain.enums.Status;
import com.roberto.helpdesk.repositories.ChamadoRepository;
import com.roberto.helpdesk.repositories.ClienteRepository;
import com.roberto.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Juliander", "829.711.280-24", "juliander@mail.com", "123");
		Tecnico tec2 = new Tecnico(null, "Jean Silva", "288.819.120-23", "jean@mail.com", "321");
		Tecnico tec3 = new Tecnico(null, "Roberto Bruno", "987.848.760.18", "roberto@mail.com", "231");
		tec3.addPerfil(Perfil.ADMIN);
		tec2.addPerfil(Perfil.TECNICO);
		tec1.addPerfil(Perfil.TECNICO);

		Cliente cli1 = new Cliente(null, "Andreia", "723.708.280-99", "andreia@mail.com", "987");
		Cliente cli2 = new Cliente(null, "Ettore", "594.949.510-18", "ettore@mail.com", "789");
		Cliente cli3 = new Cliente(null, "Issao", "243.979.900-93", "issao@mail.com", "897");

		Chamado cha1 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 01", "Primeiro chamado", tec3, cli2);
		Chamado cha2 = new Chamado(null, Prioridade.MEDIA, Status.ENCERRADO, "Chamado 02", "Segundo chamado", tec2, cli2);
		Chamado cha3 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 05", "Quinto chamado", tec3, cli1);
		Chamado cha4 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Chamado 04", "Quarto chamado", tec2, cli1);
		Chamado cha5 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 03", "Terceiro chamado", tec1, cli3);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		chamadoRepository.saveAll(Arrays.asList(cha1, cha2, cha3, cha4, cha5));
	}

}
