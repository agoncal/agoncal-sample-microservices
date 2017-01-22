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


  constructor(private _quotesService: QuotesService) { }

  ngOnInit() {
  }

  invokeQuotes(): void {
    this._quotesService.getQuote1()
      .subscribe(quote => this.quote1 = quote,
        error => this.errorMessage = <any>error);

  }

}
