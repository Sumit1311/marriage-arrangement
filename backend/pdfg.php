$pdf = new PDF();
$pdf->AddPage();

$input_array = array('a', 'b', 'c', 'd', 'e');

$farray = array_chunk($input_array, 2);
foreach($farray as $obj) {
    $yOffset = 0;
    foreach($obj as $item) {
        $pdf->SetXY(33, 28 + $yOffset);
        $pdf->SetFont('Arial', 'B', 10);
        $pdf->Cell(9.5, 7, $item, 0, 4, 'L');
        $yOffset += 40; // Y distance between letters
    }
    $pdf->AddPage();
}
$pdf->Output();