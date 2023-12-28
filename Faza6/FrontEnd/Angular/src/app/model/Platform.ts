export class Platform {
  id_platform:number;
  name:string;
  manufacturer:string;
  releaseDate:Date;
    constructor(id_platform:number,name:string,
                manufacturer:string,releaseDate:Date){
        this.id_platform=id_platform;
        this.name=name;
        this.manufacturer=manufacturer;
        this.releaseDate=releaseDate;
    }

}
