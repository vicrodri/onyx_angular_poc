import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';

@Injectable({
  providedIn: 'root'
})

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const clients = [
      { banque: 30076, agence: 2019, classement: 144539, serie: 2, sCompte: 0, name: 'Le Balcon Billete' },
      { banque: 30076, agence: 2063, classement: 122316, serie: 2, sCompte: 0, name: 'Le Otro Balcon' }
    ];
    return {clients};
  }
}
  // Overrides the genId method to ensure that a hero always has an id.
  // If the heroes array is empty,
  // the method below returns the initial number (11).
  // if the heroes array is not empty, the method below returns the highest
  // hero id + 1.
  //genId(heroes: Hero[]): number {
  //  return heroes.length > 0 ? Math.max(...heroes.map(hero => hero.id)) + 1 : 11;
  //}
