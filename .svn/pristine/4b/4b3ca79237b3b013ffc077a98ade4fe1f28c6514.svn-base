package com.topdata.toppontoweb.utils;

import com.topdata.toppontoweb.services.ServiceException;
import com.topdata.toppontoweb.services.TopPontoResponse;
import com.topdata.toppontoweb.services.Validacao;
import com.topdata.toppontoweb.utils.constantes.MSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author juliano.ezequiel
 */
@Component
public class PISValidator implements Validacao<Boolean, String> {

    @Autowired
    private TopPontoResponse topPontoResponse;

    @Override
    public Boolean validar(Boolean b, String o) throws ServiceException {

        int liTamanho = 0;
        StringBuffer lsAux = null;
        StringBuffer lsMultiplicador = new StringBuffer("3298765432");
        int liTotalizador = 0;
        int liResto = 0;
        int liMultiplicando = 0;
        int liMultiplicador = 0;
        boolean lbRetorno = true;
        int liDigito = 99;
        lsAux = new StringBuffer().append(o);
        liTamanho = lsAux.length();

        switch (o) {
            case "00000000000":
            case "11111111111":
            case "22222222222":
            case "33333333333":
            case "44444444444":
            case "55555555555":
            case "66666666666":
            case "77777777777":
            case "88888888888":
            case "99999999999":
                throw new ServiceException(topPontoResponse.alertaValidacao(MSG.FUNCIONARIO.ALERTA_PIS_INVALIDO.getResource()));

        }

        if (liTamanho != 11) {
            throw new ServiceException(topPontoResponse.alertaValidacao(MSG.FUNCIONARIO.ALERTA_PIS_INVALIDO.getResource()));
        }
        if (lbRetorno) {
            for (int i = 0; i < 10; i++) {
                liMultiplicando = Integer.parseInt(lsAux.substring(i, i + 1));
                liMultiplicador = Integer.parseInt(lsMultiplicador.substring(i, i + 1));
                liTotalizador += liMultiplicando * liMultiplicador;
            }
            liResto = 11 - liTotalizador % 11;
            liResto = liResto == 10 || liResto == 11 ? 0 : liResto;
            liDigito = Integer.parseInt("" + lsAux.charAt(10));
            lbRetorno = liResto == liDigito;
        }
        if (lbRetorno == false) {
            throw new ServiceException(topPontoResponse.alertaValidacao(MSG.FUNCIONARIO.ALERTA_PIS_INVALIDO.getResource()));
        }
        return lbRetorno;
    }

}
