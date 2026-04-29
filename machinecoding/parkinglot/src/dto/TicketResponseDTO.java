package dto;

public class TicketResponseDTO {
    private String number;

    public TicketResponseDTO(String ticketNumber) {
        this.number = ticketNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
}
