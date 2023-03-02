import { TestBed } from '@angular/core/testing';

import { VehiculosDataService } from './vehiculos-data.service';

describe('VehiculosDataService', () => {
  let service: VehiculosDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VehiculosDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
