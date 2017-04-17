import { Component, OnInit } from '@angular/core';
import {QuotesService} from "../quotes.service";

@Component({
  selector: 'qt-asynch',
  templateUrl: './asynch.component.html',
  styleUrls: ['./asynch.component.css']
})
export class AsynchComponent implements OnInit {

    quotes: string = 'Quotes';
    errorMessage: string;

    constructor(private _quotesService: QuotesService) {
    }

  ngOnInit() {
  }

    asynchQuotes(): void {
        this.errorMessage = "";
        this._quotesService.getAsynchQuotes().subscribe(quotes => this.quotes = quotes, error => this.errorMessage = <any>error);
    }
}
