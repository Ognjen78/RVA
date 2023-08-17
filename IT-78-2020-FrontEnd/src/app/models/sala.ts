import { NumberValueAccessor } from "@angular/forms";
import { Bioskop } from "./bioskop";

export class Sala {
    id!: number;
    kapacitet!:number;
    brojRedova!:number;
    bioskop!: Bioskop;
}