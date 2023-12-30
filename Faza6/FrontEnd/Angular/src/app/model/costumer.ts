export class Costumer{
  id_costumer:number;
  username: string;
  email: string;
  password: string;

constructor(id_costumer:number,username: string, email: string, password: string) {
    this.id_costumer=id_costumer;
    this.username=username;
    this.email=email;
    this.password=password;
  }

}
