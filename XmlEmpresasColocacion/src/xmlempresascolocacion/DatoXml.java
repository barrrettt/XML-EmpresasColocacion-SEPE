
package empresacolocacionxmlgenerator;

import java.util.ArrayList;

public class DatoXml {
    
    //estado valided
    private boolean validoGeneral = false;
    private boolean validoResumen = false;
    
    //general
    private String codigoAgencia = "";
    
    private String feYear ="";
    private String feMes ="";
    
    //acciones
    public ArrayList<AccionXml> acciones;
    
    //resumen
    public ResumenXml resumen;
    
    //██ METODOS
    public DatoXml(){
        acciones = new ArrayList<>();
        resumen = new ResumenXml();
    }

    //insercion de datos generales 
    public String setDataGeneral(String codigoAgencia, String fechaEnvio){
        String resultado = "";
        
        //codigo agencia
        codigoAgencia = codigoAgencia.trim();
        if (codigoAgencia.length()<=10){
            this.codigoAgencia = codigoAgencia;
        }else{
            resultado += "Error codigo agencia: máximo 10 digitos.\n";
        }
        
        //fecha envio
        fechaEnvio = fechaEnvio.trim();
        if (fechaEnvio.length()== 6){
            this.feMes = fechaEnvio.substring(0, 2);
            this.feYear = fechaEnvio.substring(2, 6);
            
        }else{
            resultado += "Fecha envio de datos: longitud distinta de 6 (MMYYYY).\n";
        }
        
        //validar
        if ("".equals(resultado)){
            validoGeneral = true;
        }else{
            validoGeneral = false;
        }
        
        return resultado;
    }
    
    //insercion de datos Resumen
    public String setDataResumen(String personasTotal,String personasPerceptoras, String personasInsercion, String personasNuevas,
            String ofertasTotales, String ofertasEnviadas, String ofertasCubiertas, String puestosTotales, String puestosCubiertos, 
            String contratosTotales, String contratosIndefinidos, String personasColocadas){
        
        String resultado = "";
        
        //personas
        if (personasTotal.length()<=10){
            try{
                this.resumen.personasTotal = Integer.valueOf(personasTotal);
            }catch(NumberFormatException exn){
                this.resumen.personasTotal = 0;
            }            
        }else{
            resultado += "Error dato resumen personasTotales.\n";
        }
        
        if (personasPerceptoras.length()<=10){
            try{
                this.resumen.personasPerceptoras = Integer.valueOf(personasPerceptoras);
            }catch(NumberFormatException exn){
                this.resumen.personasPerceptoras = 0;
            }   
        }else{
            resultado += "Error dato resumen personasPerceptoras.\n";
        }
        
        if (personasInsercion.length()<=10){
            try{
                this.resumen.personasInsercion = Integer.valueOf(personasInsercion);
            }catch(NumberFormatException exn){
                this.resumen.personasInsercion = 0;
            } 
            
        }else{
            resultado += "Error dato resumen personasInsercion.\n";
        }
        
        if (personasNuevas.length()<=10){
            try{
                this.resumen.personasNuevas = Integer.valueOf(personasNuevas);
            }catch(NumberFormatException exn){
                this.resumen.personasNuevas = 0;
            } 
        }else{
            resultado += "Error dato resumen personasNuevas.\n";
        }
        
        //ofertas
        if (ofertasTotales.length()<=10){
            try{
                this.resumen.ofertasTotal = Integer.valueOf(ofertasTotales);
            }catch(NumberFormatException exn){
                this.resumen.ofertasTotal = 0;
            } 
            
        }else{
            resultado += "Error dato resumen ofertasTotales.\n";
        }
        
        if (ofertasEnviadas.length()<=10){
            try{
                this.resumen.ofertasEnviadas = Integer.valueOf(ofertasEnviadas);
            }catch(NumberFormatException exn){
                this.resumen.ofertasEnviadas = 0;
            } 
            
        }else{
            resultado += "Error dato resumen ofertasEnviadas.\n";
        }
        
        if (ofertasCubiertas.length()<=10){
            try{
                this.resumen.ofertasCubiertas = Integer.valueOf(ofertasCubiertas);
            }catch(NumberFormatException exn){
                this.resumen.ofertasCubiertas = 0;
            } 
            
        }else{
            resultado += "Error dato resumen ofertasCubiertas.\n";
        }
        
        //puestos
        if (puestosTotales.length()<=10){
            try{
                this.resumen.puestosTotal = Integer.valueOf(puestosTotales);
            }catch(NumberFormatException exn){
                this.resumen.puestosTotal = 0;
            } 
            
        }else{
            resultado += "Error dato resumen puestosTotales.\n";
        }
        
        if (puestosCubiertos.length()<=10){
            try{
                this.resumen.puestosCubiertos = Integer.valueOf(puestosCubiertos);
            }catch(NumberFormatException exn){
                this.resumen.puestosCubiertos = 0;
            } 
            
        }else{
            resultado += "Error dato resumen puestosCubiertos.\n";
        }
        
        //contratos
        if (contratosTotales.length()<=10){
            try{
                this.resumen.contratosTotal = Integer.valueOf(contratosTotales);
            }catch(NumberFormatException exn){
                this.resumen.contratosTotal = 0;
            } 
            
        }else{
            resultado += "Error dato resumen contratosTotales.\n";
        }
        if (contratosIndefinidos.length()<=10){
            try{
                this.resumen.contratosIndefinidos = Integer.valueOf(contratosIndefinidos);
            }catch(NumberFormatException exn){
                this.resumen.contratosIndefinidos = 0;
            } 
            
        }else{
            resultado += "Error dato resumen contratosIndefinidos.\n";
        }
        
        //colocaciones totales
        if (personasColocadas.length()<=10){
            try{
                this.resumen.personasColocadas = Integer.valueOf(personasColocadas);
            }catch(NumberFormatException exn){
                this.resumen.personasColocadas = 0;
            } 
            
        }else{
            resultado += "Error dato resumen personasColocadas.\n";
        }
        
        
        //█ mirar relaciones numericas:
        if (resumen.personasTotal != resumen.personasNuevas + resumen.personasColocadas){
            resultado += "Error resumen: PERSONAS ATENDIDAS tiene que ser igual a NUEVOS REGISTROS + PERSONAS COLOCADAS\n";
        }
        
        int count = 0;
        for (AccionXml acc : this.acciones){
            if (acc.isColocacion()) count++;
        }
        if (resumen.contratosTotal!= count){
            resultado += "Error resumen: CONTRATOS SUSCRITOS tienen que ser igual al número de acciones con colocacion.\n";
        }
        
        //█VALIDAR
        if ("".equals(resultado)){
            validoResumen = true;
        }else{
            validoResumen = false;
        }
        
        return resultado;
    }
    
    //Valida los datos de las acciones
    private boolean isValidoAcciones(){
        for (AccionXml ac : acciones){
           if (!ac.valido)return false;
        }
        return true;
    }  
        
    public boolean isValid(){
        boolean result = validoGeneral && validoResumen && isValidoAcciones();
        return result;
        
    }
    
    //█ EXPORTA UN XML en String
    public String getXml(){
        
        String result  = "<?xml version='1.0' encoding='ISO-8859-1'?>\n";
        result += "<ENVIO_ENPI xsi:noNamespaceSchemaLocation=\"XML_ENPI_v1.1.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n";
        
        result += "<ENVIO_MENSUAL>\n";
        result += "<CODIGO_AGENCIA>"+this.codigoAgencia+"</CODIGO_AGENCIA>\n";
        result += "<AÑO_MES_ENVIO>"+this.feYear + this.feMes+"</AÑO_MES_ENVIO>\n";
        
        result += "<ACCIONES_REALIZADAS>\n";
        
        for (int i=0;i<this.acciones.size();i++){
            AccionXml accioActual = this.acciones.get(i);
            result += "<ACCION>\n";
            result += "<ID_TRABAJADOR>"+accioActual.getId()+"</ID_TRABAJADOR>\n";
            result += "<NOMBRE_TRABAJADOR>"+accioActual.getName()+"</NOMBRE_TRABAJADOR>\n";
            result += "<APELLIDO1_TRABAJADOR>"+accioActual.getApell1()+"</APELLIDO1_TRABAJADOR>\n";
            
            String apell2 = accioActual.getApell2();
            if (!"".equals(apell2)){
                result += "<APELLIDO2_TRABAJADOR>"+accioActual.getApell2()+"</APELLIDO2_TRABAJADOR>\n";
            }else{
                result += "<APELLIDO2_TRABAJADOR></APELLIDO2_TRABAJADOR>\n";
            }
            
            result += "<FECHA_NACIMIENTO>"+accioActual.getFnYear() +accioActual.getFnMes()+accioActual.getFnDia()+"</FECHA_NACIMIENTO>\n";
            
            result += "<SEXO_TRABAJADOR>"+ ((accioActual.isHombre())?"1":"2") +"</SEXO_TRABAJADOR>\n";
            
            String datoGradoFormativo = "00"; 
            switch (accioActual.getNivelFormativo()){
                case 0: datoGradoFormativo = "00"; break;
                case 1: datoGradoFormativo = "10"; break;
                case 2: datoGradoFormativo = "20"; break;
                case 3: datoGradoFormativo = "30"; break;
            }
            result += "<NIVEL_FORMATIVO>"+datoGradoFormativo+"</NIVEL_FORMATIVO>\n";
            
            
            result += "<DISCAPACIDAD>"+((accioActual.isDiscapacitado())?"S":"N")+"</DISCAPACIDAD>\n";
            result += "<INMIGRANTE>"+((accioActual.isInmigrante())?"S":"N")+"</INMIGRANTE>\n";
            result += "<COLOCACION>"+((accioActual.isColocacion())?"S":"N")+"</COLOCACION>\n";
            
            if (accioActual.isColocacion()){
                ColocacionXml coloca = accioActual.getColocacionXml();
                result += "<FECHA_COLOCACION>"+coloca.getFcYear()+coloca.getFcMes()+coloca.getFcDia()+"</FECHA_COLOCACION>\n";
                
                String datoTipoContrato = "001";
                switch(coloca.getTipoContrato()){
                    case 0: datoTipoContrato = "001";break;
                    case 1: datoTipoContrato = "003";break;
                    case 2: datoTipoContrato = "401";break;
                    case 3: datoTipoContrato = "501";break;
                }
                result += "<TIPO_CONTRATO>"+datoTipoContrato+"</TIPO_CONTRATO>\n";
                
                result += "<CIF_NIF_EMPRESA>"+coloca.getId()+"</CIF_NIF_EMPRESA>\n";
                result += "<RAZON_SOCIAL_EMPRESA>"+coloca.getName()+"</RAZON_SOCIAL_EMPRESA>\n";
            }
            
            result += "</ACCION>\n";
        }//fin for acciones
        result += "</ACCIONES_REALIZADAS>\n";
        
        result += "<DATOS_AGREGADOS>\n";
        
        result += "<TOTAL_PERSONAS>"+this.resumen.personasTotal+"</TOTAL_PERSONAS>\n";
        result += "<TOTAL_NUEVAS_REGISTRADAS>"+this.resumen.personasNuevas+"</TOTAL_NUEVAS_REGISTRADAS>\n";
        result += "<TOTAL_PERSONAS_PERCEPTORES>"+this.resumen.personasPerceptoras+"</TOTAL_PERSONAS_PERCEPTORES>\n";
        result += "<TOTAL_PERSONAS_INSERCION>"+this.resumen.personasInsercion+"</TOTAL_PERSONAS_INSERCION>\n";
        
        result += "<TOTAL_OFERTAS>"+this.resumen.ofertasTotal+"</TOTAL_OFERTAS>\n";
        result += "<TOTAL_OFERTAS_ENVIADAS>"+this.resumen.ofertasEnviadas+"</TOTAL_OFERTAS_ENVIADAS>\n";
        result += "<TOTAL_OFERTAS_CUBIERTAS>"+this.resumen.ofertasCubiertas+"</TOTAL_OFERTAS_CUBIERTAS>\n";
        
        result += "<TOTAL_PUESTOS>"+this.resumen.puestosTotal+"</TOTAL_PUESTOS>\n";
        result += "<TOTAL_PUESTOS_CUBIERTOS>"+this.resumen.puestosCubiertos+"</TOTAL_PUESTOS_CUBIERTOS>\n";
        
        result += "<TOTAL_CONTRATOS>"+this.resumen.contratosTotal+"</TOTAL_CONTRATOS>\n";
        result += "<TOTAL_CONTRATOS_INDEFINIDOS>"+this.resumen.contratosIndefinidos+"</TOTAL_CONTRATOS_INDEFINIDOS>\n";
        result += "<TOTAL_PERSONAS_COLOCADAS>"+this.resumen.personasColocadas+"</TOTAL_PERSONAS_COLOCADAS>\n";
        
        result += "</DATOS_AGREGADOS>\n";
        result += "</ENVIO_MENSUAL>\n";
        result += "</ENVIO_ENPI>\n";
        
        result +="<!-- FIN -->";
        
        return result;
    }
    
}//fin clase

class ResumenXml{
    public int personasTotal;
    public int personasPerceptoras;
    public int personasInsercion;
    public int personasNuevas;
    
    public int ofertasTotal;
    public int ofertasEnviadas;
    public int ofertasCubiertas;
    
    public int puestosTotal;
    public int puestosCubiertos;
    
    public int contratosTotal;
    public int contratosIndefinidos;
    
    public int personasColocadas;
    
    public static ResumenXml xmlToResumen(String strXml){
        boolean hasErrors = false;
        ResumenXml resumen = new ResumenXml();
            
        //constantes de busquedas
        String personaTotalIni = "<TOTAL_PERSONAS>"; String personaTotalFin = "</TOTAL_PERSONAS>";
        String personaNuevoIni = "<TOTAL_NUEVAS_REGISTRADAS>"; String personaNuevoFin = "</TOTAL_NUEVAS_REGISTRADAS>";
        String personaPerceptorIni = "<TOTAL_PERSONAS_PERCEPTORES>"; String personaPercepFin = "</TOTAL_PERSONAS_PERCEPTORES>";
        String personaInsercionIni = "<TOTAL_PERSONAS_INSERCION>"; String personaInsercionFin = "</TOTAL_PERSONAS_INSERCION>";
        
        String ofertaTotalIni = "<TOTAL_OFERTAS>"; String ofertaTotalFin = "</TOTAL_OFERTAS>";
        String ofertaEnviadaIni = "<TOTAL_OFERTAS_ENVIADAS>"; String ofertaEnviadaFin = "</TOTAL_OFERTAS_ENVIADAS>";
        String ofertaCubiertaIni = "<TOTAL_OFERTAS_CUBIERTAS>"; String ofertaCubiertaFin = "</TOTAL_OFERTAS_CUBIERTAS>";
        
        String puestoTotalIni = "<TOTAL_PUESTOS>"; String puestoTotalFin = "</TOTAL_PUESTOS>";
        String puestoCubiertoIni = "<TOTAL_PUESTOS_CUBIERTOS>"; String puestoCubiertoFin = "</TOTAL_PUESTOS_CUBIERTOS>";
        
        String contratoTotalIni = "<TOTAL_CONTRATOS>"; String contratoTotalFin = "</TOTAL_CONTRATOS>";
        String contratoIndefinidoIni = "<TOTAL_CONTRATOS_INDEFINIDOS>"; String contratoIndefinidoFin = "</TOTAL_CONTRATOS_INDEFINIDOS>";
        String personaColocadaIni = "<TOTAL_PERSONAS_COLOCADAS>"; String personaColocadaFin = "</TOTAL_PERSONAS_COLOCADAS>";
        
        try{
        //█ EXTRACION DE DATOS DE LA CADENA:
        int Init = strXml.indexOf(personaTotalIni);
        int Fin = strXml.indexOf(personaTotalFin);
        String value = strXml.substring(Init+personaTotalIni.length(), Fin);
        try{
            resumen.personasTotal = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(personaPerceptorIni);
        Fin = strXml.indexOf(personaPercepFin);
        value = strXml.substring(Init + personaPerceptorIni.length(), Fin);
        try{
            resumen.personasPerceptoras = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(personaInsercionIni);
        Fin = strXml.indexOf(personaInsercionFin);
        value = strXml.substring(Init + personaInsercionIni.length(), Fin);
        try{
            resumen.personasInsercion = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(personaNuevoIni);
        Fin = strXml.indexOf(personaNuevoFin);
        value = strXml.substring(Init + personaNuevoIni.length(), Fin);
        try{
            resumen.personasNuevas = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        //ofertas
        Init = strXml.indexOf(ofertaTotalIni);
        Fin = strXml.indexOf(ofertaTotalFin);
        value = strXml.substring(Init + ofertaTotalIni.length(), Fin);
        try{
            resumen.ofertasTotal = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(ofertaEnviadaIni);
        Fin = strXml.indexOf(ofertaEnviadaFin);
        value = strXml.substring(Init + ofertaEnviadaIni.length(), Fin);
        try{
            resumen.ofertasEnviadas = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(ofertaCubiertaIni);
        Fin = strXml.indexOf(ofertaCubiertaFin);
        value = strXml.substring(Init + ofertaCubiertaIni.length(), Fin);
        try{
            resumen.ofertasCubiertas = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        //puestos
        Init = strXml.indexOf(puestoTotalIni);
        Fin = strXml.indexOf(puestoTotalFin);
        value = strXml.substring(Init + puestoTotalIni.length(), Fin);
        try{
            resumen.puestosTotal = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(puestoCubiertoIni);
        Fin = strXml.indexOf(puestoCubiertoFin);
        value = strXml.substring(Init + puestoCubiertoIni.length(), Fin);
        try{
            resumen.puestosCubiertos = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        //contratos
        Init = strXml.indexOf(contratoTotalIni);
        Fin = strXml.indexOf(contratoTotalFin);
        value = strXml.substring(Init + contratoTotalIni.length(), Fin);
        try{
            resumen.contratosTotal = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(contratoIndefinidoIni);
        Fin = strXml.indexOf(contratoIndefinidoFin);
        value = strXml.substring(Init + contratoIndefinidoIni.length(), Fin);
        try{
            resumen.contratosIndefinidos = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        Init = strXml.indexOf(personaColocadaIni);
        Fin = strXml.indexOf(personaColocadaFin);
        value = strXml.substring(Init + personaColocadaIni.length(), Fin);
        try{
            resumen.personasColocadas = Integer.valueOf(value);
        }catch (NumberFormatException nfe){
            hasErrors = true;
        }
        
        //fallo general -> xml mal formado.
        }catch (Exception e){
            System.out.println("Excepcion xml to dato Resumen " + e.getMessage());
            return null;
        }
        
        // █ salida
        if (hasErrors)return null;
        return resumen;
    }
}

class AccionXml{
    
    public boolean valido = false;
    
    private String id= "";
    private String nombre = "";
    private String apell1= "";
    private String apell2= "";
    
    private String fnDia ="";;
    private String fnMes ="";;
    private String fnYear ="";
    
    private boolean sexo = true;
    private int nivelFormativo = 0;
    private boolean discapacidad = false;
    private boolean inmigrante = false;
    
    private ColocacionXml colocacion = null;
    

    //meter los datos desde el form para construir el objeto:
    String setData(String id, String nombre, String apell1, String apell2, String nacimiento, String sexo, String nivelFormativo, String discapacidad, String inmigrante) {
        String resultado = "";
        
        //dni-nie
        id = id.trim();
        if (AccionXml.isNifNie(id) && (nombre.length() <= 9) ){
            this.id = id;
        }else{
            resultado += "Revise DNI / NIE: hasta 9 digitos. (No se valida algoritmo de letra, solo tamaño máximo.)\n";
        }
        
        //nombre
        nombre = nombre.trim();
        if (nombre.length() <= 15 && nombre.length() >0){
            this.nombre = nombre;
        }else{
            resultado += "Error en nombre: longitud tiene que ser entre 1 y 15.\n";
        }
        
        //apell1
        apell1 = apell1.trim();
        if (apell1.length() <= 20 && apell1.length() >0){
            this.apell1 = apell1;
        }else{
            resultado += "Error en apellido 1: longitud tiene que ser entre 1 y 20.\n";
        }
        
        if (apell2.length() <= 20){
            this.apell2 = apell2;
        }else{
            resultado += "Apellido 2 trabajador longitud mayor de 20.\n";
        }
        
        //fecha nacimiento
        nacimiento = nacimiento.trim();
        if (nacimiento.length()== 8){
            try{
                this.fnDia = nacimiento.substring(0, 2);
                this.fnMes = nacimiento.substring(2, 4);
                this.fnYear = nacimiento.substring(4, 8); 
            }catch(NumberFormatException ex){
                resultado += "Formato numerico no aceptado en fecha de nacimiento: (DDMMYYYY).\n";
            }
        }else{
            resultado += "Fecha nacimiento trabajador longitud distinta de 8 (DDMMYYYY).\n";
        }
        
        //sexo
        if ("1".equals(sexo) || "2".equals(sexo)){
            this.sexo = ("1".equals(sexo));
        }else{
            resultado += "Problema con el formato de sexo.\n";
        }
        
        //nivel formativo
        if ("00".equals(nivelFormativo) || "10".equals(nivelFormativo) || "20".equals(nivelFormativo) || "30".equals(nivelFormativo)){
            if ("00".equals(nivelFormativo)){
                this.nivelFormativo = 0;
            }
            
            if ("10".equals(nivelFormativo)){
                this.nivelFormativo = 1;
            }
            
            if ("20".equals(nivelFormativo)){
                this.nivelFormativo = 2;
            }
            
            if ("30".equals(nivelFormativo)){
                this.nivelFormativo = 3;
            }
            
        }else{
            resultado += "Problema en nivel formativo.\n";
        }
        
        //discapacitado?
        if ("S".equals(discapacidad) || "N".equals(discapacidad)){
            this.discapacidad = ("S".equals(discapacidad));
        }else{
            resultado += "Problema con el formato discapacidad.\n";
        }
        
        //Inmigrante?
        if ("S".equals(inmigrante) || "N".equals(inmigrante)){
            this.inmigrante = ("S".equals(inmigrante));
        }else{
            resultado += "Problema con el formato inmigrante.\n";
        }
        
        //fin
        valido =  ("".equals(resultado));    
        return resultado;
    }

    String setData(String id, String nombre, String apell1, String apell2, String nacimiento, String sexo, String nivelFormativo, String discapacidad, String inmigrante, 
            String colocacion, String iDContratante, String nombreContratante, String tipoContrato, String fechaContrato) {
        
        String resultado = setData(id,nombre,apell1,apell2,nacimiento,sexo,nivelFormativo,discapacidad,inmigrante);
        
        //continua el analisis de los datos de colocacion:
        ColocacionXml coloca = new ColocacionXml();
        
        //accion de colocacion?
        if ("S".equals(colocacion) || "N".equals(colocacion)){
            resultado += coloca.setData(iDContratante,nombreContratante,tipoContrato,fechaContrato);
            this.colocacion = coloca;
        }else{
            resultado += "Problema con el formato colocacion.\n";
        }
        
        //fin
        valido =  ("".equals(resultado));
        return resultado;
    }
    
    //utilidad validacion formato dni/nie
    public static boolean isNifNie(String id){
        return true; //sacar para validar
        /*
        //si es NIE, eliminar la x,y,z inicial para tratarlo como nif (MAL!! sustituir x por el número 0. y por 1 , z por 2. y aplicar algoritmo)
        if (id.toUpperCase().startsWith("X")||id.toUpperCase().startsWith("Y")||id.toUpperCase().startsWith("Z")) {
            String initValue = "0";
            
            if (id.toUpperCase().startsWith("X")){
                initValue = "0";
            }
            
            if (id.toUpperCase().startsWith("Y")){
                initValue = "1";
            }
            
            if (id.toUpperCase().startsWith("Z")){
                initValue = "2";
            }
            
            id = initValue + id.substring(1);
            
        }

        Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher m = nifPattern.matcher(id);
        
        if(m.matches()){
           String letra = m.group(2);
           //Extraer letra del NIF
           String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
           int dni = Integer.parseInt(m.group(1));
           dni = dni % 23;
           String reference = letras.substring(dni,dni+1);

           return reference.equalsIgnoreCase(letra); //letras iguales?

        }else
            return false; //no coincide el patron.
            */
    }

    
    //GETTER
    
    String getId(){
     return this.id;
    }
    
    String getName() {
        return this.nombre ;
    }
    
    String getApell1(){
     return this.apell1;
    }
    
    String getApell2(){
     return this.apell2;
    }

    String getFnDia(){
        return this.fnDia;
    }
    
    String getFnMes(){
        return this.fnMes;
    }
    
    String getFnYear(){
        return this.fnYear;
    }
    
    boolean isHombre(){
        return this.sexo;
    }
    
    boolean isInmigrante(){
        return this.inmigrante;
    }
    
    boolean isDiscapacitado(){
        return this.discapacidad;
    }
    
    int getNivelFormativo(){
        return this.nivelFormativo;
    }
    
    //colocacion
    boolean isColocacion() {
        return (colocacion != null);
    }
    
    ColocacionXml getColocacionXml(){
        return this.colocacion;
    }

}//fin clase

class ColocacionXml{
    
    private String idContratante;
    private String nombreContratante;
    private int tipoContrato;
    
    private String fcDia ="";
    private String fcMes ="";
    private String fcYear ="";

    public String setData(String iDContratante, String nombreContratante, String tipoContrato, String fechaContrato) {
        String resultado = "";
        
        if (iDContratante.length()== 9){
            this.idContratante = iDContratante;
        }else{
            resultado += "Error en CIF/NIF del contratante: alfanumerico de 9 posiciones!\n";
        }

        if (nombreContratante.length() <=55 && nombreContratante.length()>0){
            this.nombreContratante = nombreContratante;
        }else{
            resultado += "Fallo en razon social contratante: longitud entre 1 y 55.\n";
        }
        
        fechaContrato = fechaContrato.trim();
        if (fechaContrato.length()== 8){
            this.fcDia = fechaContrato.substring(0, 2);
            this.fcMes = fechaContrato.substring(2, 4);
            this.fcYear = fechaContrato.substring(4, 8); 
        }else{
            resultado += "Fecha contratacion longitud distinta de 8 (DDMMYYYY).\n";
        }
            
        if ("001".equals(tipoContrato) || "003".equals(tipoContrato) || "401".equals(tipoContrato) || "501".equals(tipoContrato)){
            if ("001".equals(tipoContrato)){
                this.tipoContrato = 0;
            }
            
            if ("003".equals(tipoContrato)){
                this.tipoContrato = 1;
            }
            
            if ("401".equals(tipoContrato)){
                this.tipoContrato = 2;
            }
            
            if ("501".equals(tipoContrato)){
                this.tipoContrato = 3;
            }
            
        }else{
            resultado += "Error en tipo de contrato.\n";
        }
        
        
        return resultado;
    }
    
    //GETTER
    
    String getId(){
     return this.idContratante;
    }
    
    String getName() {
        return this.nombreContratante ;
    }
    
    int getTipoContrato(){
        return this.tipoContrato;
    }
    
    String getFcDia(){
        return this.fcDia;
    }
    
    String getFcMes(){
        return this.fcMes;
    }
    
    String getFcYear(){
        return this.fcYear;
    }
    
}//fin clase