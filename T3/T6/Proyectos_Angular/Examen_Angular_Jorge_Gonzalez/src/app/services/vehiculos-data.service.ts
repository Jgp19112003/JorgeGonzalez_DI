import { Injectable } from '@angular/core';
import { vehiculo } from '../utils/vehiculo';

@Injectable({
  providedIn: 'root',
})
export class VehiculosDataService {
  tipo_vehiculo = '';
  marca_buscador = ""
  cv_buscador = ""
  vehiculos = [
    {
      nombre: 'MercedesGT AMG',
      marca: 'Mercedes',
      cv: 600,
      tipo: 'deportivo',
      imagen:
        'https://www.mercedes-benz.es/passengercars/mercedes-benz-cars/models/c-class/coupe-c205/amg/equipment/_jcr_content/swipeableteaserbox/par/swipeableteaser/asset.MQ6.12.20190926164552.jpeg',
    },
    {
      nombre: 'Continental',
      marca: 'Benteley',
      cv: 400,
      tipo: 'utilitario',
      imagen: 'https://img.remediosdigitales.com/2fae93/img_1020/840_560.jpg',
    },
    {
      nombre: 'FType',
      marca: 'Jaguar',
      cv: 450,
      tipo: 'utilitario',
      imagen:
        'https://cdn.motor1.com/images/mgl/KqNVl/s1/2021-jaguar-f-type.jpg',
    },
    {
      nombre: 'GT40',
      marca: 'Ford',
      cv: 500,
      tipo: 'deportivo',
      imagen: '',
    },
    {
      nombre: 'Huayra',
      marca: 'Zonta',
      cv: 700,
      tipo: 'deportivo',
      imagen:
        'https://www.diariomotor.com/imagenes/picscache/750x/pagani-huayra-subasta-13_750x.jpg',
    },
    {
      nombre: 'LC',
      marca: 'Lexus',
      cv: 300,
      tipo: 'utilitario',
      imagen:
        'https://www.diariomotor.com/imagenes/picscache/1920x1600c/lexus-lc-500h-rojo-frontal_1920x1600c.jpg',
    },
    {
      nombre: 'LeFerrari',
      marca: 'Ferrari',
      cv: 800,
      tipo: 'deportivo',
      imagen:
        'https://www.diariomotor.com/imagenes/picscache/750x/ferrari-laferrari-fotos-dm-23_750x.jpg',
    },
    {
      nombre: 'MC600',
      marca: 'MCLaren',
      cv: 400,
      tipo: 'deportivo',
      imagen: '',
    },
    {
      nombre: 'Supra',
      marca: 'Toyota',
      cv: 300,
      tipo: 'utilitario',
      imagen:
        'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/toyota-supra-2-0l-turbo-2020-1600-01-1579020934.jpg',
    },
    {
      nombre: 'Taycan',
      marca: 'Porche',
      cv: 500,
      tipo: 'deportivo',
      imagen:
        'https://d1eip2zddc2vdv.cloudfront.net/dphotos/3844578-1567607556.jpg',
    },
  ];

  constructor() {}

  getAllVehiculos(): vehiculo[] {
    return this.vehiculos;
  }

  getVehiculosFiltrados(): vehiculo[] {
    if (
      this.tipo_vehiculo == 'deportivo' ||
      this.tipo_vehiculo == 'utilitario'
    ) {
      return this.vehiculos.filter(
        (item: vehiculo) => item.tipo == this.tipo_vehiculo
      );
    } else {
      return this.getAllVehiculos();
    }
  }

  getVehiculosBuscador(marca: string, cv: number): vehiculo[] {
      return this.vehiculos.filter(
        (item: vehiculo) => item.marca == marca && item.cv >= cv
      );
  }
}
