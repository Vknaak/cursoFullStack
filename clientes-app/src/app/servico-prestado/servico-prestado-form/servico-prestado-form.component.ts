import { Cliente } from '../../clientes/clientes';
import { ServicoPrestadoService } from './../../servico-prestado.service';
import { ClientesService } from './../../clientes.service';

import { Component, OnInit } from '@angular/core';
import { ServicoPrestado } from '../servicoPrestado';

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[] = [];
  servico: ServicoPrestado;

  constructor(
    private clienteService: ClientesService,
    private servicoPrestadoService: ServicoPrestadoService
  ) {
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {
    this.clienteService.getClientes().subscribe(response => this.clientes = response);
  }

  onSubmit() {
    console.log(this.servico);
    this.servicoPrestadoService.salvar(this.servico)
    .subscribe( response =>{})  }
}
