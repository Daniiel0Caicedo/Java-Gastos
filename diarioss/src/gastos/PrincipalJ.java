package gastos;
import gastos.Gasto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class PrincipalJ extends JFrame {

	
	private JPanel contentPane;
	
	JTextPane textLista ;
	JTextPane textMonto ;
	JTextPane textFecha ;
	JCheckBox Categoria1 ;
	JCheckBox Categoria2 ;
	JCheckBox Categoria3 ;
	JCheckBox Categoria4 ;
	JTextPane textDescripcion ; 
	JTextPane textListaTotal ;
	JTextPane Total;
	JList list;
	JScrollPane scrollPane;
	DefaultListModel<String> modelo=new DefaultListModel<>();
	
	int categoriaE = 0;
	int categoriaA = 0;
	int categoriaT = 0;
	int categoriaO = 0;
	int result = 0;

	String fechita = "";
	
	HashMap<String,Gasto > GastoD = new HashMap<String, Gasto>();
	private JScrollPane scrollPane_1;
	
	
	public PrincipalJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 493);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBackground(new Color(153, 180, 209));
		btnAgregar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnAgregar) {
					agregarGastos(GastoD);
				}
				
			}
 
			
			public void agregarGastos(HashMap<String,Gasto > GastoD) {
				Gasto newGasto = new Gasto();
				newGasto.setFecha(textFecha.getText());
				newGasto.setMonto(Integer.parseInt(textMonto.getText()));
				newGasto.setDescripcion(textDescripcion.getText());
				newGasto.setcategoriEntretenimiento(Categoria1.isSelected());
				newGasto.setcategoriAlimentacion(Categoria2.isSelected());
				newGasto.setcategoriTransporte(Categoria3.isSelected());
				newGasto.setcategoriOtros(Categoria4.isSelected());
				
				
				fechita = textFecha.getText();
				modelo = new DefaultListModel();
				modelo.addElement("fecha:"+ textFecha.getText().trim());
				list.setModel(modelo);
				textFecha.setText("");
			
				if (GastoD.containsKey(newGasto.getFecha())==false) {
				GastoD.put(newGasto.getFecha(), newGasto);
				
				
					}else {
						JOptionPane.showMessageDialog(null, "El gasto con esta Fecha ya existe");
					}
				textLista.setText("Fecha: "+ newGasto.getFecha() +"\n"+ "Monto: $"+newGasto.Monto()+"\n"+"Descripcion del Gasto: "+ newGasto.Descripcion()+"\n"+"Entretenimiento: " + newGasto.categoriEntretenimiento() +"\n"+ "Alimentacion: "+ newGasto.getcategoriAlimentacio() + "\n" + "Transporte: "+ newGasto.getcategoriaTransporte() + "\n" + "Otros: "+ newGasto.getcategoriOtros());
				
				
				 if (Categoria1.isSelected()) {	 
					 categoriaE += (newGasto.Monto());
					 
				 }
				 if (Categoria2.isSelected()) {
					 categoriaA += (newGasto.Monto());
					
				 }
				 if (Categoria3.isSelected()) {
					 categoriaT += (newGasto.Monto());
					
				 }
				 if (Categoria4.isSelected()) {
					 categoriaO += (newGasto.Monto());
					
				 }
				 result =(categoriaE + categoriaA + categoriaT + categoriaO);
				 
				 Total.setText ("Entretenimiento: $"+ categoriaE + "\n"+ "Alimentacion: $"+ categoriaA + "\n" + "Transporte: $"+ categoriaT + "\n" + "Otros: $" + categoriaO + "\n"+ "\n"+ "Gasto total: $" + result);
				 
					
				}
					
			});
	
		btnAgregar.setBounds(10, 420, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnBuscar = new JButton("Buscar..");
		btnBuscar.setBackground(SystemColor.activeCaption);
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				if (e.getSource() == btnBuscar) {
					buscarGastos(GastoD);
				}
			}
				public void buscarGastos(HashMap<String, Gasto> gastoD) {
					
					String fecha =JOptionPane.showInputDialog("Ingrese la fecha en la que realizo el gasto");
					if (GastoD.containsKey(fecha)== true) {
						Gasto gastoDiario=GastoD.get(fecha);
						
					textListaTotal.setText("Fecha: "+ gastoDiario.getFecha()+"\n"+ "Monto: $"+ gastoDiario.Monto()+"\n"+"Descripcion del Gasto: "+ gastoDiario.Descripcion()+"\n"+"Entretenimiento: " + gastoDiario.categoriEntretenimiento() +"\n"+ "Alimentacion: "+ gastoDiario.getcategoriAlimentacio() + "\n" + "Transporte: "+ gastoDiario.getcategoriaTransporte() + "\n" + "Otros: "+ gastoDiario.getcategoriOtros());
						
					}else {
						JOptionPane.showMessageDialog(null, "El Gasto NO EXISTE");
					}
				}
		}
		);
		
		btnBuscar.setBounds(208, 420, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar ");
		btnEliminar.setBackground(SystemColor.activeCaption);
		btnEliminar.setBounds(109, 420, 89, 23);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnEliminar) {
					eliminarGastos(GastoD);
				
			}
		}

			private void eliminarGastos(HashMap<String, Gasto> gastoD) {
				String fecha =JOptionPane.showInputDialog("Ingrese la Fecha de gasto que desea Eliminar.");
				if (GastoD.containsKey(fecha)) {
					GastoD.remove(fecha);	
					textListaTotal.setText("");
					textLista.setText("");	
					Total.setText("");

					if (Categoria1.isSelected()){
						categoriaE =(0);
					}
						
					if (Categoria2.isSelected()){
						categoriaA =(0);
					}
						
					if (Categoria3.isSelected()){
						categoriaT =(0);
					}
						
					if (Categoria4.isSelected()){
						categoriaO =(0);
					}		
					
					JOptionPane.showMessageDialog(null, "EL Gasto a sido Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "El Gasto NO EXISTE");
				}
				
			}	
		});
		
		textFecha = new JTextPane();
		textFecha.setToolTipText("");
		textFecha.setBackground(SystemColor.inactiveCaption);
		textFecha.setBounds(48, 59, 117, 23);
		contentPane.add(textFecha);
		
		JLabel fechaN = new JLabel("Fecha ");
		fechaN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fechaN.setBounds(83, 42, 46, 14);
		contentPane.add(fechaN);
		
		JLabel lblRegistraTusGastos = new JLabel("REGISTRA TUS GASTOS DIARIOS");
		lblRegistraTusGastos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistraTusGastos.setForeground(SystemColor.activeCaption);
		lblRegistraTusGastos.setBackground(new Color(255, 0, 0));
		lblRegistraTusGastos.setBounds(20, 11, 356, 23);
		contentPane.add(lblRegistraTusGastos);
		
		JLabel lblNewLabel = new JLabel("Categor\u00EDa de gastos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(48, 86, 130, 23);
		contentPane.add(lblNewLabel);
		
		textDescripcion = new JTextPane();
		textDescripcion.setBackground(SystemColor.inactiveCaption);
		textDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDescripcion.setBounds(41, 240, 144, 138);
		contentPane.add(textDescripcion);
		
		JLabel ibDescripcion = new JLabel("Descripcion");
		ibDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ibDescripcion.setBounds(70, 217, 81, 23);
		contentPane.add(ibDescripcion);
		
		textMonto = new JTextPane();
		textMonto.setToolTipText("int");
		textMonto.setBackground(SystemColor.inactiveCaption);
		textMonto.setContentType("number");
		textMonto.setBounds(197, 59, 97, 23);
		contentPane.add(textMonto);
		
		JLabel lblNewLabel_1 = new JLabel("Monto del gasto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(203, 42, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		textLista = new JTextPane();
		textLista.setBackground(SystemColor.inactiveCaption);
		textLista.setEditable(false);
		textLista.setBounds(315, 217, 181, 212);
		contentPane.add(textLista);
		
		JLabel lista = new JLabel("TOTAL");
		lista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lista.setBounds(487, 11, 74, 14);
		contentPane.add(lista);
		
		Categoria1 = new JCheckBox("Entretenimiento");
		Categoria1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Categoria1.setBounds(41, 107, 125, 23);
		contentPane.add(Categoria1);
		
		Categoria2 = new JCheckBox("Alimentación");
		Categoria2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Categoria2.setBounds(41, 134, 125, 23);
		contentPane.add(Categoria2);
		
		Categoria3 = new JCheckBox("Transporte");
		Categoria3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Categoria3.setBounds(41, 160, 125, 23);
		contentPane.add(Categoria3);
		
		Categoria4 = new JCheckBox("Otros");
		Categoria4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Categoria4.setBounds(41, 187, 125, 23);
		contentPane.add(Categoria4);
		
		JLabel lblNewLabel_2 = new JLabel("$");
		lblNewLabel_2.setBounds(187, 62, 21, 20);
		contentPane.add(lblNewLabel_2);
		
		textListaTotal = new JTextPane();
		textListaTotal.setBackground(SystemColor.inactiveCaption);
		textListaTotal.setEditable(false);
		textListaTotal.setBounds(506, 217, 181, 212);
		contentPane.add(textListaTotal);
		
		
		
		Total = new JTextPane();
		Total.setEditable(false);
		Total.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Total.setBackground(SystemColor.activeCaption);
		Total.setBounds(543, 11, 144, 138);
		contentPane.add(Total);
		
		JLabel lblNewLabel_3 = new JLabel("Gasto Encontrado");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(545, 196, 130, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gasto Ingresado");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(349, 192, 130, 18);
		contentPane.add(lblNewLabel_4);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(342, 11, 117, 90);
		contentPane.add(scrollPane_1);
		
		list = new JList();
		list.setValueIsAdjusting(true);
		scrollPane_1.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBackground(SystemColor.activeCaption);
		
			
		
	}
}
