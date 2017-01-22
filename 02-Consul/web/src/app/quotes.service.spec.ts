/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { QuotesService } from './quotes.service';

describe('QuotesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QuotesService]
    });
  });

  it('should ...', inject([QuotesService], (service: QuotesService) => {
    expect(service).toBeTruthy();
  }));
});
