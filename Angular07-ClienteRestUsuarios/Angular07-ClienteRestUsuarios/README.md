# Angular07ClienteRestUsuarios

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 15.2.4.

## Elementos explicados
- Usa Bootstrap. Instalado en Angular.json
- Emplea REST
- Hace un servicio REST por medio de rxJS
- uso de la directiva *ngFor
- Trabaja un filtro en el listado

----

## Para instalar Bootstrap (https://justcodeit.io/arrancar-proyecto-angular-6-bootstrap-4/)
en node_modules

        npm install bootstrap  

Luego tendremos que modificar el fichero angular.json, para extender la sección styles que quedará como sigue a continuación.

         "styles":  [
             "node_modules/bootstrap/dist/css/bootstrap.css"
             "src/styles.css"
          ],


## Para instalar las fuentes
        npm install font-awesome  

iremos una vez más al fichero angular.json y extendemos la sección styles, quedando de la siguiente forma:

       "styles":  [
            "node_modules/bootstrap/dist/css/bootstrap.css",
            "node_modules/font-awesome/css/font-awesome.css",
            "src/styles.css"
       ],

---

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
