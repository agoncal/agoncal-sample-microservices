import { BrowserModule } from '@angular/platform-browser';
import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AlertModule } from 'ng2-bootstrap';

import { AppComponent } from './app.component';
import { QuotesComponent } from './quotes/quotes.component';
import {QuotesService} from "./quotes.service";
import { ChainComponent } from './chain/chain.component';
import { AggregateComponent } from './aggregate/aggregate.component';
import { AsynchComponent } from './asynch/asynch.component';

@NgModule({
  declarations: [
    AppComponent,
    QuotesComponent,
    ChainComponent,
    AggregateComponent,
    AsynchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AlertModule.forRoot()
  ],
  providers: [QuotesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
