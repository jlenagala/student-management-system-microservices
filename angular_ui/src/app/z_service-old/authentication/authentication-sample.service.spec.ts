import { TestBed } from '@angular/core/testing';

import { AuthenticationSampleService } from './authentication-sample.service';

describe('AuthenticationSampleService', () => {
  let service: AuthenticationSampleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationSampleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
