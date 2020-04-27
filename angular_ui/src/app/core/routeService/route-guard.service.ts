import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationSampleService } from '../../z_service-old/authentication/authentication-sample.service';
import { TokenStorageService } from 'src/app/auth/services/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {
  isLoggedIn = false;
  constructor(
    private tokenStorageService: TokenStorageService,
    private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn)
      return true;

    this.router.navigate(['login'])
    return false;
  }
}
