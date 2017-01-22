import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Response, Http} from "@angular/http";

@Injectable()
export class QuotesService {

  private _quote1Url = 'localhost:8081/quotes';
  private _quote2Url = 'localhost:8082/quotes';
  private _quote3Url = 'localhost:8083/quotes';
  private _quote4Url = 'localhost:8084/quotes';
  private _quote5Url = 'localhost:8085/quotes';
  private _quote6Url = 'localhost:8086/quotes';

  constructor(private _http: Http) {
  }

  getQuote1(): Observable<string> {
    return this._http.get(this._quote1Url)
      .map((response: Response) => <string> response.text())
      .do(data => console.log('All: ' + JSON.stringify(data)))
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    // in a real world app, we may send the server to some remote logging infrastructure
    // instead of just logging it to the console
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

}
