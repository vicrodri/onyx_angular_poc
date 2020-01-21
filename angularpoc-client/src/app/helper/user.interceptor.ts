import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { UserService } from '../user.service';

@Injectable()
export class UserInterceptor implements HttpInterceptor {

    constructor(private userService: UserService) {}

    intercept (request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const currentUser = this.userService.getUserInfo();

        if(currentUser) {
            let userKey = window.btoa(JSON.stringify(currentUser));
            request = request.clone({
                setHeaders: {
                    Authorization: `Basic ${userKey}`
                }
            })
        }
        return next.handle(request);
    }

}