import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationSampleService {

  constructor() { }

  authenticate(username, password) {
    //console.log('before '+this.isUserLoggedIn());
    if (username === "jan" && password === 'jan123') {
      sessionStorage.setItem('authenticatedUser', username)
      // console.log('before '+this.isUserLoggedIn());

      return true;
    }
    return false;
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('authenticatedUser')
  }
}
