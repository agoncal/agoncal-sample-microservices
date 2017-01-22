import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Response, Http} from "@angular/http";

@Injectable()
export class QuotesService {

  private _quote1Url = 'http://localhost:8081/quotes';
  private _quote2Url = 'http://localhost:8082/quotes';
  private _quote3Url = 'http://localhost:8083/quotes';
  private _quote4Url = 'http://localhost:8084/quotes';
  private _quote5Url = 'http://localhost:8085/quotes';
  private _quote6Url = 'http://localhost:8086/quotes';

  constructor(private _http: Http) {
  }

  getQuote1(): Observable<string> {
    return this._http.get(this._quote1Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('Quote 1 received: ' + data))
      .catch(this.handleError);
  }

  getQuote2(): Observable<string> {
    return this._http.get(this._quote2Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('Quote 2 received: ' + data))
      .catch(this.handleError);
  }

  getQuote3(): Observable<string> {
    return this._http.get(this._quote3Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('Quote 3 received: ' + data))
      .catch(this.handleError);
  }

  getQuote4(): Observable<string> {
    return this._http.get(this._quote4Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('Quote 4 received: ' + data))
      .catch(this.handleError);
  }

  getQuote5(): Observable<string> {
    return this._http.get(this._quote5Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('Quote 5 received: ' + data))
      .catch(this.handleError);
  }

  getQuote6(): Observable<string> {
    return this._http.get(this._quote6Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('Quote 6 received: ' + data))
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
