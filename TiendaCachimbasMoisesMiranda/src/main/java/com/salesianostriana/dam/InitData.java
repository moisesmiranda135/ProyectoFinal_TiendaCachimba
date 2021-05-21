package com.salesianostriana.dam;



import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.modal.Cachimba;
import com.salesianostriana.dam.modal.Marca;
import com.salesianostriana.dam.servicios.CachimbaServicio;
import com.salesianostriana.dam.servicios.MarcaServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final CachimbaServicio caServicio;
	private final MarcaServicio marServicio;
	
	
	

	
	@PostConstruct
	public void init () {
		
		Marca a = new Marca ("Aladyn","Una cachimba aladin, es la prueba de que los buenos materiales y los precios baratos no son incompatibles. Por eso, nos trae todos sus modelos fabricados de acero inoxidable V2A y con un difusor regulable de tres niveles que nos proporciona un tiro desde cerrado hasta abierto pasando por niveles intermedios en función de la posición del difusor.\n"
				+ "\n"
				+ "Su fundación es de 1986 y su fabricación es en Egipto, siendo una cachimba de nacionalidad alemana. Todas sus purgas están fabricadas con una bola de vidrio y en función del modelo tienen una estética diferente (vertical hacia arriba, de tres salidas, una salida…), asegurándose en todas una purga completa de la base con un suave soplido.");
		
		Marca b = new Marca ("Mr.Shisha","Mr Shisha, fue fundada en 2016. Se caracteriza por su rediseño constante dentro del mundo de la cachimba además de aportar novedades como el sistema de purga vertical hacia arriba y/o hacia abajo dependiendo del modelo. La exclusividad en sus productos y sobre todo la calidad de sus materiales unido a sus bajos precios hacen de esta marca, una de las mejores del mercado.");
		
		Marca c =  new Marca ("VZ Hookah", "La marca Cachimbas VZ Hookah apuesta por la fabricación a mano de todos sus productos, convirtiéndolos así en más exclusivos si cabe y de una preparación con más cautela. Teniendo así, un producto único de cada unidad que es fabricada.\n"
				+ "\n"
				+ "De esta forma, podemos adquirir productos de todo tipo de diseños y alturas, teniendo modelos de apenas 35 centímetros hasta modelos más altos de unos 58 centímetros. De la misma forma, al tener un tipo de cámara tradicional y una conexión con la base mediante arandelas en unos modelos y con goma a presión otros, esta marca nos ofrece la posibilidad de combinar el mástil con cualquier tipo de base que más se acople a nuestras exigencias. Obteniendo un modelo con un diseño propio y único, uniéndolo a la ya exclusividad propia de cada unidad.");
		
		marServicio.save(a);
		marServicio.save(b);
		marServicio.save(c);
		
		Cachimba ca = new Cachimba ("MVP 360","Acero","Acero inoxidable", "La cachimba MVP 360 es una cachimba de acero inoxidable de 36 cm provista de un equipamiento completo ya que se entrega con una manguera de silicona con mango de metal y un muelle, una cazoleta de terracota además de un difusor integrado regulable ",80.0,36,1,"https://www.hispacachimba.es/image/cache/catalog/aladin/cachimba-aladin-mvp-360-rainbow-550x550h.jpg");
		caServicio.save(ca);
		Cachimba cb = new Cachimba ("MVP 460","Acero","Acero inoxidable", "La cachimba Aladin MVP 460 ",100.70,46,1,"https://www.hispacachimba.es/image/cache/catalog/aladin/cachimba-aladin-mvp-460-model-2-glass-1-clear-550x550h.jpg");
		caServicio.save(cb);
		Cachimba cc = new Cachimba ("Rocket 2.0","azul","Acero inoxidable", "La Rocket 2.0",100.50,1,1,"https://www.hispacachimba.es/image/cache/catalog/mrshisha/cachimba-mrshisha-megatron-20-blue-matte-resin-550x550.jpg");
		caServicio.save(cc);
		Cachimba cd = new Cachimba ("Khalifa Gold","Oro","Acero inoxidable", "Una cachimba fabricada totalmente de acero inoxidable V2A, con una cámara tradicional que te permitirá acoplar tu cachimba a cualquier base y garantizando su purga efectiva y completa con un simple soplido.",155.95,55,1,"https://www.hispacachimba.es/image/cache/catalog/mrshisha/cachimba-mrshisha-khalifa-bronze-sin-base-550x550.jpg");
		caServicio.save(cd);
		Cachimba ce = new Cachimba ("2 GO","Acero","Acero inoxidable", "La marca alemana aladin presento, este año 2019 su cachimba mas pequeña y manejable. (Aladin 2 GO) Fabricada y diseñada con los mejores materiales (acero inoxidable) nos traen este modelo considerado calidad precio la mejor opción como cachimba de transporte. Su tiro a diferencia de los otros modelos si que es a difusor sin regular. La cámara encaja a rosca con la lase permitiendo un sellado perfecto.",44.95,20,1,"https://www.hispacachimba.es/image/cache/catalog/aladin/cachimba-aladin-2go-550x550h.jpg");
		caServicio.save(ce);
		Cachimba cf = new Cachimba ("MVP 670 Flower","Acero","Acero inoxidable", "La marca aladin, nos sorprende con este maravilloso modelo moderno que llama la atención por su tamaño (67cm aprox) y su estética. El modelo ms grande de la marca con bases talladas y materiales de acero inoxidable como en todos sus modelos. Esta al igual que el resto contiene el difusor regulable que permite adaptar la restricción de la fumada al gusto de cada uno. A diferencia del resto de modelos de mvp est no permite adaptar el recoge melaza característico alemán dado que el pato va conectado al mástil.",139.95,67,1,"https://www.hispacachimba.es/image/cache/catalog/aladin/cachimba-aladin-mvp-480-bottom-blue-550x550.jpg");
		caServicio.save(cf);
		Cachimba cg = new Cachimba ("Brass","Acero","Acero inoxidable con recubrimientode latón", "La marca rusa VZ Hookah nos trae una de las cachimbas más elegantes del mercado, su modelo Brass. Está fabricado completamente de acero inoxidable V2A con un recubrimiento de latón que le da esa imagen de elegancia y exclusividad. Una cachimba con una bola de purga de vidrio y un difusor regulable de tres niveles. Su conexión con la base es a presión con una goma de silicona, igual que el modelo Custom y/o Minimal. Si tu objetivo es hacerte con una de las cachimbas más codiciadas del mercado, la VZ Hookah Brass es la cachimba que buscas.",439.95,60,1,"https://www.hispacachimba.es/image/cache/catalog/rusia/cachimba-vz-hookah-copper-550x550w.jpg");
		caServicio.save(cg);
		
		
		a.addCachimba(cb);
		a.addCachimba(ca);
		b.addCachimba(cc);
		b.addCachimba(cd);
		a.addCachimba(ce);
		a.addCachimba(cf);
		c.addCachimba(cg);
		
		caServicio.edit(ca);
		caServicio.edit(cc);
		caServicio.edit(cb);
		caServicio.edit(cd);
		caServicio.edit(ce);
		caServicio.edit(cf);
		caServicio.edit(cg);
		
		
		
		
		
	}
}
