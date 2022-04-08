import { TestBed } from '@angular/core/testing';

import { StoreResponsesService } from './store-responses.service';

describe('StoreResponsesService', () => {
  let service: StoreResponsesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StoreResponsesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
