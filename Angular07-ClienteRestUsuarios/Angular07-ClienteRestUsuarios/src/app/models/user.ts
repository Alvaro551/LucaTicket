//Podria usar interfaces, pero en user-add hago un new()
export class User {
    id: string;
    firstName: string;
    lastName: string;
    email: string;

    /*
    constructor(id: string, firstName: string, lastName: string, email: string) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    Desde Typescript 2.7 se necesita tener constructores... o más bien que esten los datos inicializados
    Hay varias formas de hacerlo.. desde pasar del warning poniendo opcioens en archicos de configuracion hasta declarar y dar valor por defecto a los objetos
    https://stackoverflow.com/questions/71382071/angular-property-has-no-initializer-and-is-not-definitely-assigned-in-the-c
    https://stackoverflow.com/questions/49699067/property-has-no-initializer-and-is-not-definitely-assigned-in-the-construc
    https://stackoverflow.com/questions/64874221/property-has-no-initializer-and-is-not-definitely-assigned-in-the-constructor
    */
    constructor(){
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }
}