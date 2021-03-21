import { ClientesService } from './../../clientes.service';
import { Cliente } from './../clientes';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';



@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  success: boolean = false;
  errors: String[];
  id: number;

  constructor(
    private service: ClientesService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.cliente = new Cliente();
  }

  ngOnInit(): void {
    let params = this.activatedRoute.params
      .subscribe(params => {
        if (params && params['id']) {
          this.service.getClienteById(params.id)
            .subscribe(
              response => this.cliente = response,
              errorResponse => this.cliente = new Cliente()
            )
        }
      })
  }
  onSubmit() {
    if (this.id) {
      this.service.autalizar(this.cliente)
      .subscribe(response => {
        this.success = true;
        this.errors =null;
      }, errorResponse => {
        this.errors = ['Erro ao atualizar o cliente.']
      })

    } else {
      this.service
        .salvar(this.cliente)
        .subscribe(response => {
          this.success = true;
          this.errors = null;
          this.cliente = response;
        }, errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;
        })
    }
  }

  voltar() {
    this.router.navigate(['/clientes-lista']);
  }


}
