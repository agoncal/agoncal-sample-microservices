import { Component, OnInit } from '@angular/core';
import {QuotesService} from "../quotes.service";

@Component({
  selector: 'qt-aggregate',
  templateUrl: './aggregate.component.html',
  styleUrls: ['./aggregate.component.css']
})
export class AggregateComponent implements OnInit {

    quotes: string = 'Quotes';
    errorMessage: string;

    constructor(private _quotesService: QuotesService) {
    }

  ngOnInit() {
  }

    aggregateQuotes(): void {
        this.errorMessage = "";
        this._quotesService.getAggregatedQuotes().subscribe(quotes => this.quotes = quotes, error => this.errorMessage = <any>error);
    }
}
