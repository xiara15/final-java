package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import FinalprogramacionII.MetodosGeneral;

public class Producto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<Producto> listaProducto = new ArrayList<>();
	

	//ATRIBUTOS
	private int codigo;
    private String detalle;
    private double precio;
    private String marca;
    private String material;
    private Categoria categoria;
    private int stock;
    
    //CONSTRUCTORES
    public Producto() {
        this.codigo = codigo;
        this.detalle = detalle;
        this.precio = precio;
        this.marca = marca;
        this.material = material;
        this.categoria = categoria;
        this.stock = stock;
    }


    // Getters y setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

//METODOS 
    
    //ALTA PRODUCTO
    public Producto altaProducto() {
        try (Scanner entrada = new Scanner(System.in)) {
            int codigo = MetodosGeneral.castearEntero("Ingrese el código del producto: ", detalle);

            Producto productoExistente = buscarProductoCodigo(codigo);

            if (productoExistente != null) {
                System.out.println("El producto " + codigo + " ya existe.");
                System.out.println(productoExistente.getDetalle());
                System.out.println("¿Desea agregar otro producto? (si/no)");
                String respuesta = entrada.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    return null;
                }
            }

            System.out.println("Nombre del producto: ");
            System.out.println("Ingrese la marca del producto: ");
            System.out.println("Ingrese el material del producto: ");
            System.out.println("Seleccione la categoría del producto: ");
            Categoria[] categorias = Categoria.values();
            boolean flag = false;
            do {
                for (int i = 0; i < categorias.length; i++) {
                    System.out.println((i + 1) + ". " + categorias[i].obtenerCategoria());
                }
                int opcion = MetodosGeneral.castearEntero("Elija una opción: ", detalle);
                if (opcion >= 1 && opcion <= categorias.length) {
                    flag = true;
                } else {
                    System.out.println("Intente nuevamente.");
                }
            } while (!flag);

            Producto nuevoProducto = new Producto();
            listaProducto.add(nuevoProducto);
            System.out.println("Producto creado con éxito.");
            return nuevoProducto;
        }
    }

    
    //BAJA PRODUCTO
    public void bajaProducto() {
        int codigo = MetodosGeneral.castearEntero("Ingrese el código del producto a eliminar: ", detalle);
        Producto productoExistente = buscarProductoCodigo(codigo);
        if (productoExistente == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        listaProducto.remove(productoExistente);
        System.out.println("El producto fue eliminado.");
    }

    
    //MODIFICAR PRODUCTO
    public void modificarProducto() {
        int codigo = MetodosGeneral.castearEntero("Ingrese el código del producto a modificar: ", detalle);
        Producto productoExistente = buscarProductoCodigo(codigo);
        if (productoExistente == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        try (Scanner entrada = new Scanner(System.in)) {
            int opcion;
            boolean salir = false;

            do {
                System.out.println("Producto encontrado:");
                System.out.println("1- Detalle: " + productoExistente.getDetalle());
                System.out.println("2- Precio: " + productoExistente.getPrecio());
                System.out.println("3- Marca: " + productoExistente.getMarca());
                System.out.println("4- Material: " + productoExistente.getMaterial());
                System.out.println("5- Categoría: " + productoExistente.getCategoria().obtenerCategoria());
                System.out.println("6- Stock: " + productoExistente.getStock());
                System.out.println("7- Salir");
                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Nuevo detalle:");
                        productoExistente.setDetalle(entrada.nextLine());
                        break;
                    case 2:
                        productoExistente.setPrecio(MetodosGeneral.castearDecimal("Nuevo precio: ", detalle));
                        break;
                    case 3:
                        System.out.println("Nueva marca:");
                        productoExistente.setMarca(entrada.nextLine());
                        break;
                    case 4:
                        System.out.println("Nuevo material:");
                        productoExistente.setMaterial(entrada.nextLine());
                        break;
                    case 5:
                        Categoria[] categorias = Categoria.values();
                        Categoria nuevaCategoria = null;
                        boolean flag = false;
                        do {
                            for (int i = 0; i < categorias.length; i++) {
                                System.out.println((i + 1) + ". " + categorias[i].obtenerCategoria());
                            }
                            int opcionCat = MetodosGeneral.castearEntero("Elija una opción: ", detalle);
                            if (opcionCat >= 1 && opcionCat <= categorias.length) {
                                nuevaCategoria = categorias[opcionCat - 1];
                                flag = true;
                            } else {
                                System.out.println("Intente nuevamente.");
                            }
                        } while (!flag);
                        productoExistente.setCategoria(nuevaCategoria);
                        break;
                    case 6:
                        productoExistente.setStock(MetodosGeneral.castearEntero("Nuevo stock: ", detalle));
                        break;
                    case 7:
                        salir = true;
                        System.out.println("Saliendo del sistema.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            } while (!salir);
        }

        System.out.println("Producto modificado con éxito.");
    }

    
    //BUSCAR PRODUCTO
    public static Producto buscarProductoCodigo(int codigo) {
        for (Producto p : listaProducto) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    
    //VER DETALLE PRODUCTO
    public static void verDetalleProducto() {
        if (listaProducto.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : listaProducto) {
                System.out.println("------------------------------");
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Detalle: " + p.getDetalle());
                System.out.println("Precio: $" + p.getPrecio());
                System.out.println("Marca: " + p.getMarca());
                System.out.println("Material: " + p.getMaterial());
                System.out.println("Categoría: " + p.getCategoria().obtenerCategoria());
                System.out.println("Stock: " + p.getStock());
            }
        }
    }

    
    //MENU DE PRODUCTOS
    public void menuProducto() {
        try (Scanner entrada = new Scanner(System.in)) {
            int opcion;
            boolean salir = false;

            do {
                System.out.println("------ MENÚ PRODUCTO ------");
                System.out.println("1- Crear un producto");
                System.out.println("2- Eliminar un producto");
                System.out.println("3- Modificar un producto");
                System.out.println("4- Ver productos");
                System.out.println("5- Salir");
                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        altaProducto();
                        break;
                    case 2:
                        bajaProducto();
                        break;
                    case 3:
                        modificarProducto();
                        break;
                    case 4:
                        verDetalleProducto();
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                        break;
                }
            } while (!salir);
        }
    }
}
	        

