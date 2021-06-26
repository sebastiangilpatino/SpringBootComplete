package mvc.service;

import mvc.domain.Account;
import mvc.domain.Transacctions;

import java.util.ArrayList;
import java.util.List;

public class TransacctionsAdapter {

    public static Transacctions getTransaction(TransacctionsDTO transacctionsDTO){
        Transacctions transacctions = new Transacctions();
        if(transacctionsDTO != null) {
            transacctions = new Transacctions(transacctionsDTO.getDate(), transacctionsDTO.getAmount(), transacctionsDTO.getAccountNumber());
        }
        return transacctions;
    }

    public static TransacctionsDTO getTransactionDTO(Transacctions transacctions){
        TransacctionsDTO transacctionsDTO = new TransacctionsDTO();
        if(transacctions != null) {
            transacctionsDTO = new TransacctionsDTO(transacctions.getDate(), transacctions.getAmount(), transacctions.getAccountNumber());
        }
        return transacctionsDTO;
    }


    public static List<Transacctions> adapt2Transacction(List<TransacctionsDTO> transacctionsDTO) {

        List<Transacctions> transacctions = new ArrayList<Transacctions>();

        if (transacctionsDTO != null) {

            for (int i = 0; i < transacctionsDTO.size(); i++) {
                transacctions.add(new Transacctions(transacctionsDTO.get(i).getDate(),
                        transacctionsDTO.get(i).getAmount(),
                        transacctionsDTO.get(i).getAccountNumber()));
            }

        }
        return transacctions;
    }

    public static List<TransacctionsDTO> adapt2TransacctionDTO(List<Transacctions> transacction) {
        List<TransacctionsDTO> transacctionsDTO = new ArrayList<TransacctionsDTO>();
        if (transacction != null) {
            for (int i = 0; i < transacction.size(); i++) {
                transacctionsDTO.add(new TransacctionsDTO(transacction.get(i).getDate(),
                        transacction.get(i).getAmount(),
                        transacction.get(i).getAccountNumber()));
            }
        }
        return transacctionsDTO;
    }
}
