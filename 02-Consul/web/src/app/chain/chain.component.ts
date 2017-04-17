import { Component, OnInit } from '@angular/core';
import {QuotesService} from "../quotes.service";

@Component({
  selector: 'qt-chain',
  templateUrl: './chain.component.html',
  styleUrls: ['./chain.component.css']
})
export class ChainComponent implements OnInit {

    quotes: string = 'Quotes';
    errorMessage: string;

    constructor(private _quotesService: QuotesService) {
    }

  ngOnInit() {
  }

    chainQuotes(): void {
        this.errorMessage = "";
        this._quotesService.getChainedQuotes().subscribe(quotes => this.quotes = quotes, error => this.errorMessage = <any>error);
    }
}
