package net.javaguides.springmvc.controller;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import net.javaguides.springmvc.entity.Laboratorio;
import net.javaguides.springmvc.entity.Medicamento;
import net.javaguides.springmvc.entity.TipoMedicamento;
import net.javaguides.springmvc.service.LaboratorioService;
import net.javaguides.springmvc.service.MedicamentoService;
import net.javaguides.springmvc.service.TipoMedicamentoService;
@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String principal(Model theModel) {
		theModel.addAttribute("dataLaboratorio",laboratorioService.getLaboratorios());
		return "list-medicamento";
	}	
	@RequestMapping(value="/listaMedicamentos", method=RequestMethod.GET)
	public String listaMedicamentos(Model theModel) {
		theModel.addAttribute("dataMedicamento",medicamentoService.getMedicamentos());
		return "tabla-medicamento";
	}
	@RequestMapping(value="/saveMedicamento",method=RequestMethod.POST)
	public String saveMedicamento(
			@RequestParam("codigo") int codigo,
			@RequestParam("nombre") String nombre,
			@RequestParam("laboratorio") int codLab,
			@RequestParam("tipo") int codTipo,
			@RequestParam("stock") int stock,
			@RequestParam("precio") double precio,
			@RequestParam("fecha") String fecha, @RequestParam("file") MultipartFile file) {
		try {
			Date fec=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Medicamento med=new Medicamento();
			Laboratorio lab=new Laboratorio();
			TipoMedicamento tipo=new TipoMedicamento();
			lab.setCodLaboratorio(codLab);
			tipo.setCodTipoMedicamento(codTipo);
			med.setCodMedicamento(codigo);
			med.setNomMedicamento(nombre);
			med.setLaboratorio(lab);
			med.setTipoMedicamento(tipo);
			med.setStockMedicamento(stock);
			med.setPrecioMedicamento(precio);
			fec=sdf.parse(fecha);
			med.setFechaMedicamento(fec);
			med.setFoto(file.getBytes());
			medicamentoService.saveMedicamento(med);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medicamento/";
	}  
	@RequestMapping(value="/deleteMedicamento", method=RequestMethod.POST)
    public String deleteMedicamento(@RequestParam("codigo") int cod){
		medicamentoService.deleteMedicamento(cod);
		return "redirect:/medicamento/";
	}	
	
	@RequestMapping(value = "/listaTipoMedicamentoXLaboratorio", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> listaTipoMedicamentoXLaboratorio(@RequestParam("codigo")int cod) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<TipoMedicamento> theTipoMedicamento = tipoMedicamentoService.listTipoMedicamentos(cod);
		map.put("keyTipo", theTipoMedicamento);
		return map;
	}
}
