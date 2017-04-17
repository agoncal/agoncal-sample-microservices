import { Component, OnInit } from '@angular/core';
import {QuotesService} from "../quotes.service";

@Component({
  selector: 'qt-quotes',
  templateUrl: './quotes.component.html',
  styleUrls: ['./quotes.component.css']
})
export class QuotesComponent implements OnInit {

  quote1: string = 'Quote 1';
  quote2: string = 'Quote 2';
  quote3: string = 'Quote 3';
  quote4: string = 'Quote 4';
  quote5: string = 'Quote 5';
  quote6: string = 'Quote 6';
  errorMessage: string;

  constructor(private _quotesService: QuotesService) {
  }

  ngOnInit() {
  }

  invokeQuotes(): void {
    this.errorMessage = "";
    this._quotesService.getQuote1().subscribe(quote => this.quote1 = quote, error => this.errorMessage = <any>error);
    this._quotesService.getQuote2().subscribe(quote => this.quote2 = quote, error => this.errorMessage = <any>error);
    this._quotesService.getQuote3().subscribe(quote => this.quote3 = quote, error => this.errorMessage = <any>error);
    this._quotesService.getQuote4().subscribe(quote => this.quote4 = quote, error => this.errorMessage = <any>error);
    this._quotesService.getQuote5().subscribe(quote => this.quote5 = quote, error => this.errorMessage = <any>error);
    this._quotesService.getQuote6().subscribe(quote => this.quote6 = quote, error => this.errorMessage = <any>error);
  }
}
